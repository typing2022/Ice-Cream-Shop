package Service;


import DAO.OrderRepository;
import Model.Order;

import java.util.List;

public class OrderService {
    OrderRepository ordrep;

    public OrderService() {
        this.ordrep = new OrderRepository() ;
    }

    public List<Order> getAllOrders(){
        return ordrep.getAllOrders();
    }

    public void addOrder(int orderId, String date, double tax, double amount, double totalAmount){
        //Painting existingPainting = pr.getPaintingByTitle(title);
        //if(existingPainting == null) {
        Order newOrder = new Order(orderId, date, tax,amount, totalAmount);
        ordrep.addOrder(newOrder);
        //}else{
//            do nothing
        //}
    }
}
