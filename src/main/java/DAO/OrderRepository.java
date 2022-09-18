package DAO;

import Model.IceCream;
import Model.Order;
import Model.Order;
import Util.ConnectionDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    Connection conn;

    public OrderRepository(){
        conn = ConnectionDb.getConnection();
    }

    public List<Order> getAllOrders(){
        List<Order> allOrders = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From orders");
            while(rs.next()){
                Order loadedOrder = new Order(rs.getInt("Orderid"),rs.getString("date"),rs.getDouble("tax"), rs.getDouble("amount"), rs.getDouble("totalAmount"));
                allOrders.add(loadedOrder);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allOrders;
    }

    public Order getOrderByOrderId(int orderId){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from orders where orderId = ?");

            statement.setInt(1,orderId );
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Order order = new Order( rs.getInt("Orderid"),rs.getString("date"),rs.getDouble("tax"), rs.getDouble("amount"), rs.getDouble("totalAmount"));
                return order;
            }
        }catch(SQLException e){

        }
        return null;
    }


    public Order getMaxNumber() throws SQLException {
        //List<Order> allOrders = new ArrayList<>();
        int num = 0;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select max(orderId) as maxNumber From orders");

            while(rs.next()) {
                //    Order loadedOrder = new Order(rs.getInt("Orderid"),rs.getString("date"),rs.getDouble("tax"), rs.getDouble("amount"), rs.getDouble("totalAmount"));
                //   allOrders.add(loadedOrder);
              Order order = new Order(rs.getInt("maxNumber"));
               // num = rs.getInt("maxNumber");
          return order;

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }



    public void addOrder(Order order){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into Orders( date, tax,amount, totalAmount) " +
                    "values ( ?, ?, ?,?)");

            statement.setString(1, order.getDate());
            statement.setDouble(2, order.getTax());
            statement.setDouble(3, order.getAmount());
            statement.setDouble(4, order.getTotalAmount());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void saveOrder(Order order){
        try{
            PreparedStatement statement = conn.prepareStatement("update  orders set tax = ?,  amount = ? ,  totalAmount = ? where orderId = ? ") ;
            statement.setDouble(1, order.getTax());
            statement.setDouble(2, order.getAmount());
            statement.setDouble(3, order.getTotalAmount());
            statement.setInt(4, order.getorderId());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int deleteOrder(int id){
        try{
            PreparedStatement statement = conn.prepareStatement("delete from   orders where orderId =  ? ") ;
            statement.setInt(1,id);
           int num =   statement.executeUpdate();
           return num;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }


}
