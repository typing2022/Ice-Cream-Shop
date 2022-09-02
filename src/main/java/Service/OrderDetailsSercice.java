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

    public void OrderDetails(int orderDetailsId, int orderId , List<Product> produts ){
        //Painting existingPainting = pr.getPaintingByTitle(title);
        //if(existingPainting == null) {
        OrderDetails newOrder = new OrderDetails( orderDetailsId,  orderId ,  produts );
        ordrep.addOrderDetails(newOrder);
        //}else{
//            do nothing
        //}
    }


}
