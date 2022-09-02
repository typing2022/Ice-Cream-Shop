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
                OrderDetails loadedOrder = new OrderDetails(rs.getInt("orderDetailsId"),rs.getInt("orderId"));
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
                OrderDetails or = new OrderDetails( rs.getInt("orderDetailsId"),rs.getInt("orderId"));
                return or;
            }
        }catch(SQLException e){

        }
        return null;
    }

    public void addOrderDetails(OrderDetails order){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into OrderDetails( orderDetailsId, productName,orderId,numberOfProduct,amount) " +
                    "values (?, ?, ? ,? ,?)");
            statement.setInt(1, order.getOrderDetailsId());
            statement.setString(2, order.getProductName());
            statement.setInt(3, order.getOrderId());
            statement.setInt(4, order.getNumberOfProduct());
            statement.setDouble(1, order.getAmount());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
