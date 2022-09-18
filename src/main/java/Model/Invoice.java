package Model;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Invoice {

    //instance variables with a private access modifier
    private String typeOfPay ;

    //Creating  Order object
    Order order = new Order();
    DefaultTableModel tableModel = new DefaultTableModel();
    JTable table = new JTable(tableModel);



    //Generate our Getters and Setters
    public String getTypeOfPay(){
        return typeOfPay ;
    }
    public void setTypeOfPay(String typeOfPay){
        this.typeOfPay = typeOfPay;
    }

    //method for printing invoice.
    public void printInvoice( Order order){


        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println("Revature Ice Cream Shop  ");
        System.out.println(order.getDate());
        System.out.println("--------------------------------------------------------");
        for (Product product : order.getProducts()){

            System.out.println(product.name + "         " + product.amount);
        }

        order.setTotalAmount(order.getAmount() + order.getTax());
        System.out.println("--------------------------------------------------------");
        System.out.println("Amount:                " + order.getAmount());
        System.out.println("Tax:                   " + order.getTax());
        System.out.println("--------------------------------------------------------");
        System.out.println("Total amount:          " + String.format("%.2f",(order.getTotalAmount())));
        System.out.println("--------------------------------------------------------");

    }

}
