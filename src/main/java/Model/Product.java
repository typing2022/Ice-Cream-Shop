package Model;
import java.util.ArrayList;
public abstract class Product {

    int id;

    //instance variable with a public access modifier
    public   String name;
    public   double amount;
    public ArrayList<Product> products = new ArrayList<>();

    //Abstract Method ordering product and return list of product object
    public abstract ArrayList<Product> orderingItems();


}
