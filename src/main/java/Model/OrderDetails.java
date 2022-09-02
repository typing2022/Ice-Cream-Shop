package Model;

import java.util.ArrayList;
import java.util.List;

public class OrderDetails {

    //instance variables with a private access modifier
    private int orderDetailsId;
    private String productName;
    private int orderId;
    private int numberOfProduct;
    private double amount ;

    private List<Product> produts = new ArrayList<>();

    public OrderDetails() {
    }


    public OrderDetails(int orderDetailsId, int orderId ) {
        this.orderDetailsId = orderDetailsId;
        this.orderId = orderId;


    }
    public OrderDetails(int orderDetailsId, int orderId , List<Product> produts ) {
        this.orderDetailsId = orderDetailsId;
        this.orderDetailsId = orderDetailsId;
        this.orderId = orderId;
        this.produts = produts;

    }

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public String getProductName() {
        return productName;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public double getAmount() {
        return amount;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

