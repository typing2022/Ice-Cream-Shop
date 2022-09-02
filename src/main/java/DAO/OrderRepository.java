package DAO;

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

    public void addOrder(Order order){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into Orders(orderId, date, tax,amount, totalAmount) " +
                    "values (?, ?, ?, ?)");
            statement.setInt(1, order.getorderId());
            statement.setString(2, order.getDate());
            statement.setDouble(3, order.getTax());
            statement.setDouble(4, order.getAmount());
            statement.setDouble(5, order.getTotalAmount());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
