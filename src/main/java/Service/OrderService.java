package Service;


import DAO.OrderRepository;
import Model.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    OrderRepository ordrep;

    public OrderService() {
        this.ordrep = new OrderRepository() ;
    }

    public List<Order> getAllOrders(){
        return ordrep.getAllOrders();
    }

    public Order getMaxNumber() throws SQLException {

             return ordrep.getMaxNumber();

    }

    public void addOrder(Order order){

        ordrep.addOrder(order);

    }

    public void saveOrder(Order order){

        ordrep.saveOrder(order);

    }

    public int deleteOrder(int id){

     int num =    ordrep.deleteOrder(id);
     return num;
    }
}
