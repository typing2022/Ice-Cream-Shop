package Model;

public class Invoice {

    //instance variables with a private access modifier
    private String typeOfPay ;

    //Creating  Order object
    Order order = new Order();

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
        System.out.println("Randy Ice Cream Shop  ");
        System.out.println(order.getDate());
        System.out.println("--------------------------------------------------------");
        for (Product product : order.getProducts()){
            System.out.println(product.name + " " + product.amount);
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("Amount: " + order.getTotalAmount());
        System.out.println("Tax: " + order.getTax());
        System.out.println("Total amount: " + String.format("%.2f",(order.getTotalAmount() - order.getTax())));

    }

}
