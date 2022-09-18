package Model;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
public class LoggingTest {
    public  static Logging logging ;
    @BeforeClass
    public static void setUp(){

        int Id = 1;
        String name = "ice tea";
        logging = new Logging(1,"jone","ad123","user");


    }

    @Test
    public  void  toStringTest(){
        String expected = "user Name='jone', password='ad123', user Role='user'";
        String actual = logging.toString();
        Assert.assertEquals(expected, actual);
    }
}
