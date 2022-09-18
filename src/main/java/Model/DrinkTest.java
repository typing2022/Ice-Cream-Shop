package Model;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
public class DrinkTest {
    public  static Drink drink ;
    @BeforeClass
    public static void setUp(){

        int Id = 1;
        String name = "ice tea";
        drink = new Drink(1,"pepsi",1);


    }

    @Test
    public  void  toStringTest(){
        String expected = "Drink name:     pepsi  Amount: 1.0";
        String actual = drink.toString();
        Assert.assertEquals(expected, actual);
    }

}
