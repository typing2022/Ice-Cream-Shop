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
    public void addIceCream(IceCream ic){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into iceCream(id ,name, amount) " +
                    "values (?, ?,?)");
            statement.setInt(1, ic.getId());
            statement.setString(2, ic.getName());
            statement.setDouble(3, ic.getAmount());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}
