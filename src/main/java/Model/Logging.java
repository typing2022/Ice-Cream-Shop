package Model;

import Service.IceCreamService;
import Service.DrinkService;
import Service.LoggingService;

import java.sql.SQLException;
import java.util.Scanner;

public class Logging {

    // Assigning private variables
    private int id ;
    private String userName;
    private String password;
    private String userRole;

    //First version of constructor
    public  Logging(){ }

    //Second version of constructor

    public Logging(String userName, String password, String userRole) {

        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }
    public Logging(int id, String userName, String password, String userRole) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }

    //Generating  Getters and Setters
    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return  "user Name='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", user Role='" + userRole + '\'' ;
    }

    // Method for administration duty
 /*   public boolean adminAction(){
        //Assigning variables
        int choice;
        int newId = 0;
        String iceCreamName, drinkName, userName, password, userRole = "";
        boolean stillWorking = true ;
        double iceCramPrice, drinkPrice ;

        //Creating Scanner objects
        Scanner sc = new Scanner(System.in);
        Scanner scline = new Scanner(System.in);

        while (stillWorking == true) {

            //Interface for Ice cream list
            System.out.println("Please select a number:\n"
                    + " 1) add new user\n"
                    + " 2) delete user\n"
                    + " 3) add new ice cream\n"
                    + " 4) add new drink\n"
                    + "and any other number for nothing!");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Inter user name : ");
                userName = scline.nextLine();

                System.out.println("Inter password  :");
                password = scline.nextLine();

                System.out.println("Inter user role  :");
                userRole = scline.nextLine();

                LoggingService loser = new LoggingService();
                try {
                    newId = loser.getMaxIdNumber();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                //Adding user record to the logging table
                loser.addLogging(newId + 1, userName, password,userRole);
                System.out.println(" You added  user: "  + userName  + "   successfully");

            } else if(choice == 2) {
                System.out.println("Inter user name : ");
                userName = scline.nextLine();

                LoggingService logser = new LoggingService();

                // //Deleting  user record from  the logging table
                logser.deleteLogging(userName);
                System.out.println(" You deleted  user: "  + userName  + "   successfully");
            } else if(choice == 3) {
                System.out.println("Inter ice cream name : ");
                iceCreamName = scline.nextLine();

                System.out.println("Inter ice cream price  ");
                iceCramPrice = scline.nextInt();

                IceCreamService iceser = new IceCreamService();
                try {
                    newId = iceser.getMaxIdNumber();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                //Adding ice cream record to the ice cream table
                iceser.addIceCream(newId +1, iceCreamName, iceCramPrice);
                System.out.println(" You added ice cream: "  + iceCreamName  + "  successfully");

            } else if (choice == 4) {
                System.out.println("Inter drink name : ");
                drinkName = scline.nextLine();

                System.out.println("Inter drink price  ");
                drinkPrice = scline.nextInt();

                DrinkService driser = new DrinkService();
                try {
                    newId = driser.getMaxIdNumber();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                ////Adding drink record to the drink table
                driser.addDrink(newId + 1, drinkName, drinkPrice);

                System.out.println("You added drink: "  + drinkName  + "  successfully");

            }

            System.out.println("\nWelcome to Revature Ice Cream Shop! Please select a number:\n"
                    + "1) keep doing admin stuff \n"
                    + "2) exit\n"
                    + "and any other number for nothing!");

            choice = sc.nextInt();
            if (choice == 2) {
                stillWorking = false;

            }

        }// stillWorking loop

        return stillWorking;
    }*/

}
