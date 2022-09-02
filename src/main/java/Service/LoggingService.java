package Service;
import DAO.LoggingRepository;
import Model.IceCream;
import Model.Logging;

import java.util.List;

public class LoggingService {

    LoggingRepository lorep;

    public LoggingService() {
        this.lorep = new LoggingRepository() ;
    }

    public List<Logging> getAllLoggings(){
        return lorep.getAllLoggings();
    }

    public Logging getLogging(String userName, String password  )
    {
        return lorep.getLogging(userName, password);
    }

    public void addLogging(int id,String userName, String password, String userAuthorizization){
        //Painting existingPainting = pr.getPaintingByTitle(title);
        //if(existingPainting == null) {
        Logging newLogging = new Logging(id,userName, password,userAuthorizization);
        lorep.addLogging(newLogging);
        //}else{
//            do nothing
        //}
    }
}
