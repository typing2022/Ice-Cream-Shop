package DAO;

import Model.Drink;
import Model.IceCream;
import Util.ConnectionDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrinkRepository {
    Connection conn;

    public DrinkRepository() {
        this.conn = ConnectionDb.getConnection();
    }

    public List<Drink> getAllDrinks(){
        List<Drink> allIceCreams = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * From drink");
            while(rs.next()){
                Drink loadedDrink = new Drink(rs.getInt("id"),rs.getString("name"), rs.getDouble("amount"));
                allIceCreams.add(loadedDrink);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allIceCreams;
    }

    public Drink getDrinkByName(String name){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from drink where name = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Drink dr = new Drink(rs.getInt("id"), rs.getString("name"), rs.getDouble("amount"));
                return dr;
            }
        }catch(SQLException e){

        }
        return null;
    }

    public Drink getDrinkById(int id){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from drink where id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Drink dr = new Drink(rs.getInt("id"), rs.getString("name"), rs.getDouble("amount"));
                return dr;
            }
        }catch(SQLException e){

        }
        return null;
    }
    public void addDrink(Drink drink){
        try{
            PreparedStatement statement = conn.prepareStatement("insert into drink(id ,name, amount) " +
                    "values (?, ?,?)");
            statement.setInt(1, drink.getId());
            statement.setString(2, drink.getName());
            statement.setDouble(3, drink.getAmount());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
