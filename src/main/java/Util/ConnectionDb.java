package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {

    private static Connection conn;
    public static Connection getConnection(){
        if(conn == null){
            try{
                String url = "jdbc:sqlserver://iceshop.database.windows.net;database=db1;TrustServerCertificate=True";
                String username = "abdel";
                String password = "Password123#";
                conn = DriverManager.getConnection(url, username, password);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return conn;
    }


}
