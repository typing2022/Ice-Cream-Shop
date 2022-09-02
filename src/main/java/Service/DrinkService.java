package Service;
import DAO.DrinkRepository;
import DAO.IceCreamRepository;
import Model.Drink;
import Model.IceCream;

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

    public void addDrink(int id,String name, double amount){
        //Painting existingPainting = pr.getPaintingByTitle(title);
        //if(existingPainting == null) {
        Drink newDrink = new Drink(id,name, amount);
        drep.addDrink(newDrink);
        //}else{
//            do nothing
        //}
    }
}
