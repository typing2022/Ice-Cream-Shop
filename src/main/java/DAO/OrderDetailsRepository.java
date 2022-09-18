package DAO;

import Model.IceCream;
import Model.Order;
import Model.OrderDetails;
import Util.ConnectionDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsRepository {

    Connection conn;
    public OrderDetailsRepository(){
        conn = ConnectionDb.getConnection();
    }

    public List<OrderDetails> getAllOrderDetails(){
        List<OrderDetails> allOrderDetails = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From orderDetails");
            while(rs.next()){
                OrderDetails loadedOrder = new OrderDetails(rs.getInt("orderDetailsId"),rs.getInt("orderId"), rs.getString("productName"),rs.getDouble("amount"));
                allOrderDetails.add(loadedOrder);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allOrderDetails;
    }

    public OrderDetails getOrderDetailsByOrderId(int orderId){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from orderDetails where orderId = ?");

            statement.setInt(1,orderId );
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                OrderDetails or = new OrderDetails( rs.getInt("orderDetailsId"),rs.getInt("orderId"), rs.getString("productName"),rs.getDouble("amount"));
                return or;
            }
        }catch(SQLException e){

        }
        return null;
    }

    public void addOrderDetails(OrderDetails order){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into orderDetails( orderId,productName,amount) " +
                    "values ( ?, ? ,? )");

            statement.setInt(1, order.getOrderId());
            statement.setString(2, order.getProductName());
            statement.setDouble(3, order.getAmount());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public int deleteOrderDetails(int id){
        try{
            PreparedStatement statement = conn.prepareStatement("delete from orderDetails where orderId = ? " );
            statement.setInt(1, id);
        int num =    statement.executeUpdate();
        return num;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

}
