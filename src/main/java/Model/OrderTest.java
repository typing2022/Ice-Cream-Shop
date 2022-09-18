package Model;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    public static Order  order ;
    public static Product product1;
    public static Product product2;
    double amount = 0;

    public static ArrayList<Product> products = new ArrayList<>();

    @BeforeClass
    public static void setUp(){

        int Id = 1;
        String name = "ice tea";
        order = new Order();
        product1 = new Drink(1, "ice tea",  1) ;
        product2 = new Drink(2, "pepsi",  1) ;
        products.add(product1);
        products.add(product2);

    }

    @Test
    public  void  sumAmountTest(){

        double expected =  2;
        order.sumAmount(products);
        double actual = order.getAmount();
        Assert.assertEquals(expected, actual, .1);
    }

    @Test
    public void  calculateTaxTest(){
        double expected =  .02;
        order.calculateTax();
        double actual = order.getTax();
        Assert.assertEquals(expected, actual, .1);
    }


}
