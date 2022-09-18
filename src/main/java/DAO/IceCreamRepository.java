package DAO;

import Util.ConnectionDb;
import Model.IceCream;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class IceCreamRepository {
    Connection conn;

    public IceCreamRepository(){
        conn = ConnectionDb.getConnection();
    }
    public List<IceCream> getAllIceCreams(){
        List<IceCream> allIceCreams = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From iceCream");
            while(rs.next()){
                IceCream loadedPainting = new IceCream(rs.getInt("id"),rs.getString("name"), rs.getDouble("amount"));
                allIceCreams.add(loadedPainting);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allIceCreams;
    }

    public IceCream getIceCreamByName(String name){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from iceCream where name = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                IceCream ic = new IceCream( rs.getInt("id"),rs.getString("name"), rs.getDouble("amount"));
                return ic;
            }
        }catch(SQLException e){

        }
        return null;
    }

    public IceCream getIceCreamById(int id){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from iceCream where id= ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                IceCream ic = new IceCream( rs.getInt("id"),rs.getString("name"), rs.getDouble("amount"));
                return ic;
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
            ResultSet rs = statement.executeQuery("Select max(Id) as maxNumber From icecream");
            while(rs.next()) {
                //    Order loadedOrder = new Order(rs.getInt("Orderid"),rs.getString("date"),rs.getDouble("tax"), rs.getDouble("amount"), rs.getDouble("totalAmount"));
                //   allOrders.add(loadedOrder);
                num = rs.getInt("maxNumber");
               // IceCream ic = new IceCream(rs.getInt("maxNumber"),"",0);
                //num = rs.getInt("maxNumber");


            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return num;
    }

    public IceCream getMaxIdNumber2() throws SQLException {
        //List<Order> allOrders = new ArrayList<>();
        // int num = 0;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select max(Id) as maxNumber From icecream");
            while(rs.next()) {
                //    Order loadedOrder = new Order(rs.getInt("Orderid"),rs.getString("date"),rs.getDouble("tax"), rs.getDouble("amount"), rs.getDouble("totalAmount"));
                //   allOrders.add(loadedOrder);
                //num = rs.getInt("maxNumber");
                IceCream ic = new IceCream(rs.getInt("maxNumber"),"",0);
                //num = rs.getInt("maxNumber");
                return ic;

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void addIceCream(IceCream ic){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into iceCream(name, amount) " +
                    "values ( ?,?)");

            statement.setString(1, ic.getName());
            statement.setDouble(2, ic.getAmount());
            statement.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int deleteIceCream(int id){
        try{
            PreparedStatement statement = conn.prepareStatement("delete from iceCream where id = ? ") ;                    ;
            statement.setInt(1, id);
         int num =    statement.executeUpdate();
            conn.commit();
            return num;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }



}
