package Service;
import DAO.DrinkRepository;
import DAO.IceCreamRepository;
import Model.Drink;
import Model.IceCream;

import java.sql.SQLException;
import java.util.List;

public class DrinkService {

    DrinkRepository drep;

    public DrinkService() {
        this.drep = new DrinkRepository();
    }

    public List<Drink> getAllDrinks(){
        return drep.getAllDrinks();
    }

    public Drink getDrinkByName( String name  ){
        return drep.getDrinkByName(name);
    }
    public Drink getDrinkById( int id ){
        return drep.getDrinkById(id);
    }

    public int getMaxIdNumber() throws SQLException {

           return drep.getMaxIdNumber();


    }

    public void addDrink(String name, double amount){

        Drink newDrink = new Drink(name, amount);
        drep.addDrink(newDrink);

    }

    public int deleteDrink(int id){

      int num =  drep.deleteDrink(id);
      return num;
    }
}
