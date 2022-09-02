package Model;
import java.util.ArrayList;
public class Order {
    //instance variables with a private access modifier
    private int orderId;
    private String date;

    private double tax;
    private double amount ;
    private double totalAmount ;
    private ArrayList<Product> products = new ArrayList<>();

    //first version of constructor
    public Order( ) {}
    public Order( String date,ArrayList<Product> products ) {
        this.products = products;
    }

    //Second version of constructor

    public Order(int orderId, String date, double tax,double amount, double totalAmount) {
        this.orderId = orderId;
        this.date = date;
        this.tax = tax;
        this.amount = amount;
        this.totalAmount = totalAmount;

    }



    //Generate our Getters and Setters
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public int getorderId() {
        return orderId;
    }
    public void setorderId(int orderId){
        this.orderId = orderId;
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax){
        this.tax = tax;
    }
    public double getAmount() {
        return amount;
    }
    public void setamount(double amount){
        this.amount = amount;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount){
        this.totalAmount = totalAmount;
    }
    public ArrayList<Product> getProducts(){
        return products;
    }


    //method for adding  product object to products list.
    public void addProduct(Product product){
        products.add(product);
    }

    //method for summing  amount  value of all products.
    public void  sumAmount(ArrayList<Product> products) {
        double total = 0 ;
        //iterate over products list
        for (Product product : products){
            total += product.amount;
        }

        totalAmount =  total;

    }

    //method for calculating the tax .
    public void calculateTax() throws ArithmeticException{
        tax =   totalAmount * 7/100;
    }




}
