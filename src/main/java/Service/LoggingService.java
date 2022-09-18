package Service;
import DAO.LoggingRepository;
import Model.IceCream;
import Model.Logging;

import java.sql.SQLException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
//import org.jboss.logging.MDC;

public class LoggingService {
    private Logger userLogger = LogManager.getLogger("userLoggerDB");
    LoggingRepository lorep;

    public LoggingService() {
        this.lorep = new LoggingRepository() ;
    }

    public List<Logging> getAllLoggings(){
        return lorep.getAllLogging();
    }

    public Logging getLogging(String userName, String password  )
    {
        if (lorep.getLogging(userName, password) != null){
            return lorep.getLogging(userName, password);
        } else {
            return null;
        }

    }

    public Logging getUserById(int id  )
    {
        if (lorep.getUserById(id) != null){
            return lorep.getUserById(id);
        } else {
            return null;
        }

    }
    public int getMaxIdNumber() throws SQLException {
        return lorep.getMaxIdNumber();
    }

    public void addLogging(String userName, String password, String userRole){

        Logging newLogging = new Logging(userName, password,userRole);
        lorep.addLogging(newLogging);

        ThreadContext.put("username", newLogging.getUserName());
        ThreadContext.put("field", "ALL");
        ThreadContext.put("from_value", "");
        ThreadContext.put("to_value", newLogging.getUserName());


        userLogger.info("add New user:  " + newLogging.getUserName());

        ThreadContext.clearAll();
    }



    public int deleteUser(int id){

     int num =   lorep.deleteUser(id);

       ThreadContext.put("userId", Integer.toString( id));
       ThreadContext.put("field", "ALL");
        ThreadContext.put("from_value", "");
        ThreadContext.put("to_value",Integer.toString(id));


        userLogger.info("delete user who Id number is: " + Integer.toString(id));

        ThreadContext.clearAll();
   return num;
    }
}
