package Service;
import DAO.OrderDetailsRepository;
import DAO.IceCreamRepository;
import DAO.OrderRepository;
import Model.Order;
import Model.OrderDetails;
import Model.Product;

import java.util.List;

public class OrderDetailsSercice {

    OrderDetailsRepository ordrep;

    public OrderDetailsSercice () {
        this.ordrep = new OrderDetailsRepository () ;
    }

    public List<OrderDetails> getAllOrderDetails(){
        return ordrep.getAllOrderDetails();
    }

    public void addOrderDetails( OrderDetails orderDetails ){

       // OrderDetails newItem = new OrderDetails( orderId ,productName, amount );
        ordrep.addOrderDetails(orderDetails);

    }

    public int deleteOrderDetails( int id ){

        // OrderDetails newItem = new OrderDetails( orderId ,productName, amount );
     int num =    ordrep.deleteOrderDetails(id);
          return num;
    }


}
