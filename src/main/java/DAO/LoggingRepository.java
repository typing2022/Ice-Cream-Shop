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

    public List<Logging> getAllLoggings(){
        List<Logging> allLoggings = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From logging");
            while(rs.next()){
                Logging loadedPainting = new Logging(rs.getInt("id"),rs.getString("userName"), rs.getString("password"), rs.getString("userAuthorization"));
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
                Logging lo = new Logging( rs.getInt("id"),rs.getString("userName"), rs.getString("password"), rs.getString("userAuthorization"));
                return lo;
            }
        }catch(SQLException e){

        }
        return null;
    }

    public void addLogging(Logging lo){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into logging(id ,userName, password, userAuthorization) " +
                    "values (?, ?,?)");
            statement.setInt(1, lo.getId());
            statement.setString(2, lo.getUserName());
            statement.setString(3, lo.getPassword());
            statement.setString(2, lo.getUserAuthorization());

            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}
