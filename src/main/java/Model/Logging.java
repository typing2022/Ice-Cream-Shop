package Model;

public class Logging {

    private int id ;
    private String userName;
    private String password;
    private String userAuthorization;

    public  Logging(){ }

    public Logging(int id, String userName, String password, String userAuthorization) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userAuthorization = userAuthorization;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserAuthorization() {
        return userAuthorization;
    }
}
