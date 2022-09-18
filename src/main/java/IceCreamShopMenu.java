import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.*;

import java.time.LocalDate;
import Model.*;
import Service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class IceCreamShopMenu {

    static boolean loggingDone = false;
    static String typeOfPay = "";
    static String userRole = "";

    public static void main(String[] args) throws SQLException {

        IceCreamService ps = new IceCreamService();
        DrinkService dr = new DrinkService();
        LoggingService log = new LoggingService();
        OrderService ord = new OrderService();
        OrderDetailsSercice orddet = new OrderDetailsSercice();
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);

        app.start(9000);


        //*Logging*************************************************************************************

        app.get("/iceCreamShop/users/", ctx -> {
            ctx.json(log.getAllLoggings());
        });

        app.get("/iceCreamShop/getLogging/{userName},{password}", ctx ->
        {

            //ObjectMapper mapper = new ObjectMapper();
            //Logging  requestLogging = mapper.readValue(ctx.body(), Logging.class);
            ctx.json(log.getLogging(ctx.pathParam("userName"), ctx.pathParam("password")));
        });

        app.get("/iceCreamShop/getUserById/{id}", ctx -> {
            ObjectMapper mn = new ObjectMapper();
            ctx.json(log.getUserById(Integer.parseInt(ctx.pathParam("id"))));
        });

        app.post("/iceCreamShop/addUser/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Logging requestLogging = mapper.readValue(ctx.body(), Logging.class);
            log.addLogging(requestLogging.getUserName(), requestLogging.getPassword(), requestLogging.getUserRole());
        });

        app.get("/iceCreamShop/userDeletion/{id}", ctx -> {

            ctx.json(log.deleteUser(Integer.parseInt(ctx.pathParam("id"))));
        });


        StringBuilder str = new StringBuilder();

        //  String finalStr = str;
        app.get("/paintings1/", ctx -> {
            str.setLength(0);
            ;
            for (IceCream ice : ps.getAllIceCreams()) {
                str.append(ice.getId() + " |" + ice.getName() + "| " + ice.getAmount() + " | \n");

            }
            ctx.result("List of ice cream \n" + str);

        });


        //app.get("/paintings/", ctx -> {ctx.json(ps.getAllPaintings());});

        //*IceCream*************************************************************************************

        app.get("/iceCreams/", ctx -> {
            ctx.json(ps.getAllIceCreams());
        });


        app.get("/iceCreamShop/getMaxNumber/", ctx -> {
            ctx.json(ord.getMaxNumber());
        });
        app.get("/iceCreamShop/getMaxIceNumber/", ctx -> {
            ctx.json(ps.getMaxIdNumber2());
        });

        app.get("/iceCreamShop/getIceCreamByName/{name}", ctx ->
        {
//
            ctx.json(ps.getIceCreamByName(ctx.pathParam("name")));
        });

        app.get("/iceCreamShop/getIceCreamById/{id}", ctx -> {
            ObjectMapper mn = new ObjectMapper();
            ctx.json(ps.getIceCreamById(Integer.parseInt(ctx.pathParam("id"))));
        });


        app.post("/iceCreamShop/addIceCream/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            IceCream requestPainting = mapper.readValue(ctx.body(), IceCream.class);
            ps.addIceCream(requestPainting.getName(), requestPainting.getAmount());
        });

        app.get("/iceCreamShop/iceCreamDeletion/{id}", ctx -> {

            ctx.json(ps.deleteIceCream(Integer.parseInt(ctx.pathParam("id"))));
        });

        //*Drink*************************************************************************************
        app.get("/drinks/", ctx -> {
            ctx.json(dr.getAllDrinks());
        });

        app.get("/iceCreamShop/getDrinkById/{id}", ctx -> {
            ObjectMapper mn = new ObjectMapper();
            ctx.json(dr.getDrinkById(Integer.parseInt(ctx.pathParam("id"))));
        });

        app.post("/iceCreamShop/addDrink/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            IceCream requestPainting = mapper.readValue(ctx.body(), IceCream.class);
            dr.addDrink(requestPainting.getName(), requestPainting.getAmount());
        });

        app.get("/iceCreamShop/drinkDeletion/{id}", ctx -> {

            ctx.json(dr.deleteDrink(Integer.parseInt(ctx.pathParam("id"))));
        });

        //*Order*************************************************************************************

        app.post("/iceCreamShop/addOrder/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Order requestPainting = mapper.readValue(ctx.body(), Order.class);
            ord.addOrder(requestPainting);
        });

        app.post("/iceCreamShop/saveOrder/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Order requestPainting = mapper.readValue(ctx.body(), Order.class);
            ord.saveOrder(requestPainting);
        });

        app.get("/iceCreamShop/maxIdNumber/", ctx -> {
            ctx.json(ord.getMaxNumber());
        });

        app.get("/iceCreamShop/deleteOrder/{id}", ctx -> {
            ObjectMapper mn = new ObjectMapper();
            ctx.json(ord.deleteOrder(Integer.parseInt(ctx.pathParam("id"))));
        });
        //*OrderDetails*************************************************************************************
        app.post("/iceCreamShop/OrderDetailsAddition/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            OrderDetails requestPainting = mapper.readValue(ctx.body(), OrderDetails.class);
            orddet.addOrderDetails(requestPainting);
        });

        app.get("/iceCreamShop/deleteOrderDetails/{id}", ctx -> {
            ObjectMapper mn = new ObjectMapper();
            ctx.json(orddet.deleteOrderDetails(Integer.parseInt(ctx.pathParam("id"))));
        });

    }
}
