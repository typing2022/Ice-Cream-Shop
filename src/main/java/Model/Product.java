package Model;
import java.util.ArrayList;
public abstract class Product {

    //instance variables with a private access modifier

    int id;
     String name;
     double amount;

    //instance variable with a public access modifier
    public ArrayList<Product> products = new ArrayList<>();

    //Abstract Method ordering product and return list of product object
    public abstract ArrayList<Product> orderingItems();


}
