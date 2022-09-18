package Service;
import DAO.IceCreamRepository;

import java.sql.SQLException;
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

    public int getMaxIdNumber() throws SQLException {
        return icrep.getMaxIdNumber();
    }

    public IceCream getMaxIdNumber2() throws SQLException {
        return icrep.getMaxIdNumber2();
    }

    public void addIceCream(String name, double amount){

        IceCream newIceCream = new IceCream(name, amount);
        icrep.addIceCream(newIceCream);

    }

    public int deleteIceCream(int id){
      int num = icrep.deleteIceCream(id);
       return num;
    }


}
