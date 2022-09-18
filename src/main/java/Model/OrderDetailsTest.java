package Model;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
public class OrderDetailsTest {
    public  static OrderDetails orderDetails ;
    @BeforeClass
    public static void setUp(){

        int Id = 1;
        String name = "ice tea";
        orderDetails = new OrderDetails(1,2,"ice cake",3);


    }

    @Test
    public  void  toStringTest(){
        String expected = "productName='ice cake', orderId=2, numberOfProduct=0, amount=3.0";
        String actual = orderDetails.toString();
        Assert.assertEquals(expected, actual);
    }



}
