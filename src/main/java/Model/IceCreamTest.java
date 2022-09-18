package Model;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
public class IceCreamTest {
    public  static IceCream iceCream ;
    @BeforeClass
    public static void setUp(){

        int Id = 1;
        String name = "ice cake";
        iceCream = new IceCream(1,"pepsi",3);


    }

    @Test
    public  void  toStringTest(){
        String expected = "Ice Cream name: pepsi    Amount:3.0";
        String actual = iceCream.toString();
        Assert.assertEquals(expected, actual);
    }
}
