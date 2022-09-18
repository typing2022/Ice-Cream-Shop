package Model;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.testng.annotations.BeforeClass;

public class InvoiceTest {
    public static Order order;
    public static  Invoice invoice;
    @BeforeClass
    public static void setUp(){

        int orderId = 1;
        String date = "01/01/2022";
        double tax = .5;
       double amount = 3;
       double totalAmount = 0;


        order = new Order(orderId, date, tax,amount, totalAmount);
         invoice = new Invoice();

    }

    @Test
    public  void  printInvoiceTest(){

        double expected =  3.5;
        invoice.printInvoice(order);
        double actual = order.getTotalAmount();
        Assert.assertEquals(expected, actual, .1);
    }

}
