package Service;
import DAO.IceCreamRepository;

import java.util.List;
import  Model.IceCream;
public class IceCreamService {

    IceCreamRepository icrep;

    public IceCreamService() {
        this.icrep = new IceCreamRepository() ;
    }

    public List<IceCream> getAllIceCreams(){
        return icrep.getAllIceCreams();
    }

    public IceCream getIceCreamByName( String name  ){
        return icrep.getIceCreamByName(name);
    }

    public IceCream getIceCreamById( int id  ){
        return icrep.getIceCreamById(id);
    }

    public void addIceCream(int id,String name, double amount){
        //Painting existingPainting = pr.getPaintingByTitle(title);
        //if(existingPainting == null) {
        IceCream newIceCream = new IceCream(id,name, amount);
        icrep.addIceCream(newIceCream);
        //}else{
//            do nothing
        //}
    }
}
