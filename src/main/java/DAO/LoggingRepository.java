package DAO;

import Model.IceCream;
import Model.Logging;
import Util.ConnectionDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoggingRepository {

    Connection conn;

    public LoggingRepository(){
        conn = ConnectionDb.getConnection();
    }

    public List<Logging> getAllLogging(){
        List<Logging> allLoggings = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From logging");
            while(rs.next()){
                Logging loadedPainting = new Logging(rs.getInt("id"),rs.getString("userName"), rs.getString("password"), rs.getString("userRole"));
                allLoggings.add(loadedPainting);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allLoggings;
    }

    public Logging getLogging(String userName, String password){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from logging where userName = ? and password = ? ");
            statement.setString(1, userName);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Logging lo = new Logging( rs.getInt("id"),rs.getString("userName"), rs.getString("password"), rs.getString("userRole"));
                return lo;
            }
        }catch(SQLException e){

        }
        return null;
    }

    public Logging getUserById(int id){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from logging where id = ?  ");
            statement.setInt(1, id);


            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Logging lo = new Logging( rs.getInt("id"),rs.getString("userName"), rs.getString("password"), rs.getString("userRole"));
                return lo;
            }
        }catch(SQLException e){

        }
        return null;
    }
    public int getMaxIdNumber() throws SQLException {
        //List<Order> allOrders = new ArrayList<>();
        int num = 0;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select max(Id) as maxNumber From logging");
            while(rs.next()) {
                //    Order loadedOrder = new Order(rs.getInt("Orderid"),rs.getString("date"),rs.getDouble("tax"), rs.getDouble("amount"), rs.getDouble("totalAmount"));
                //   allOrders.add(loadedOrder);

                num = rs.getInt("maxNumber");

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return num;
    }

    public void addLogging(Logging lo){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into logging(userName, password, userRole) " +
                    "values (?,?,?)");

            statement.setString(1, lo.getUserName());
            statement.setString(2, lo.getPassword());
            statement.setString(3, lo.getUserRole());

            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int deleteUser(int id){
        try{
            PreparedStatement statement = conn.prepareStatement("delete from logging  where id = ? " );
            statement.setInt(1, id);
          int num =   statement.executeUpdate();
          return num;
        }catch(SQLException e){
            e.printStackTrace();

        }
        return 0;
    }


}
