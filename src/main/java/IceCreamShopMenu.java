import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalDate;
import Model.*;
import Service.*;
public class IceCreamShopMenu {

    static boolean loggingDone = false;
    static String typeOfPay = "";

    public static void main(String[] args) {

        //connection
        IceCreamService ics = new IceCreamService();
        DrinkService drs = new DrinkService();


        //Creating  object of Scanner
        Scanner sc = new Scanner(System.in);

        //String str = stringSC.nextLine();

        //Assgin variable
        String type = "";
        String date = "";
        int choice;
        String strChoice, strChoice1 = "";

        boolean stillworking = true;

        //Creating  object of Date
        LocalDate myObj = LocalDate.now();
        date = myObj.toString();

        while (stillworking == true) { //(1)  the main loop
            //logging
            if (loggingDone == false) {
                layoutOfLogging(stillworking);
            }

          //........................................................................................
            // start ordering

            do {//(2)   iterate for checking that a customer selected  one number between 1 : 2

                System.out.println("\nWelcome to Revature Ice Cream Shop! Please select a number:\n"
                        + "1) stay here\n"
                        + "2) to go\n"
                        + "and any other number for nothing!");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("You select here!");
                        type = "here";
                         break;
                    case 2:
                        System.out.println("You select to go!");
                        type = "to go";
                        break;
                    default:
                        System.out.println("You have to select one number from numbers between 1 to 2!");
                        break;
                }
            }
            while (choice != 1 && choice != 2); //(2)

          //..............................................................................................
            //ordering ice Cream

            //Creating  object of IceCream
            IceCream iceCream = new IceCream();


            //assign list of product object
            ArrayList<Product> iceCreamProducts = new ArrayList<>();
            ArrayList<Product> drinkProducts = new ArrayList<>();
            ArrayList<Product> products = new ArrayList<>();

            //call "orderingItems" method of ice cream  object to return a list of product object
            iceCreamProducts = iceCream.orderingItems();


          //......................................................................................
            // ordering drink

            do {//(3)    iterate for checking that a customer selected  one number between 1 : 2
                System.out.println("\nDO you want drink:\n"
                        + "1) Yes\n"
                        + "2) No\n"
                        + "and any other number for nothing!");

                choice = sc.nextInt();
                if (choice == 1) {
                    //Creating  object of Drink
                    Drink drink = new Drink();


                    //call "orderingItems" method of drink object and return a list of product object;
                    drinkProducts = drink.orderingItems();

                } else if (choice == 2) {
                    System.out.println("No drink");
                } else {
                    System.out.println("You have to select one number from numbers between 1 to 2");
                }
            } while (choice != 1 && choice != 2); //(3)
          //..............,,,,,,,,,,,,,,,,,,,,,,...........................................................
            //how to pay

            // calling LayoutHowToPay(); method
            LayoutHowToPay();

          //..................................................................................................
            // do all calculation and print invoice

            //Creating  object of Invoice
            Invoice invoice = new Invoice();
            invoice.setTypeOfPay(typeOfPay);

            //iterate for moving ice cream objects from iceCreamProducts list to products list
            for (Product product : iceCreamProducts) {
                products.add(product);
            }

            //iterate for moving drink objects from drinkProducts list to products list
            for (Product product : drinkProducts) {
                products.add(product);
            }


            //Creating  object of order
            Order order = new Order(date, products);

            //Calling sumAmount method to sum amounts of all object
            order.sumAmount(products);

            //Calling calculateTax method to calculate the tax
            try {
                order.calculateTax();
            } catch (ArithmeticException ex) {
                System.out.println("Don't divide by 0!");
            } catch (Exception e) {
                System.out.println("Some other exception");
            }


            //Calling printInvoice method to print invoice
            invoice.printInvoice(order);

            System.out.println("wawaw");
            choice = sc.nextInt();

          //  sc.close();

        }//(1)
    }


  // layoutOfLogging method for logging
    public static void layoutOfLogging(boolean stillworking) {

        int choice;
        String strChoice, strChoice1 = "";
        Scanner sc = new Scanner(System.in);
        boolean logging = true;
        do { // loop for logging
        System.out.println("Please select a number:\n"
                + " 1) log in\n"
                + " 2) quit\n"
                + "and any other number for nothing!");
        choice = sc.nextInt();


        if (choice == 2) { //if(1)
            stillworking = false;

        } else {  // check username and password
            //String username, password = "";

            LoggingService loser = new LoggingService();
            Logging log = new Logging();



                //user interface  of logging
                String username, password = "";
                Scanner stringSC = new Scanner(System.in);

                System.out.println("Inter user name : ");
                username = stringSC.nextLine();

                System.out.println("Inter password : ");
                password = stringSC.nextLine();

                log = loser.getLogging(username, password);
                if (log == null) {
                    System.out.println("the user name or password is uncorrect, Try again ");
                    //continue;
                    loggingDone = false;
                } else {
                    System.out.println("wel come : " + log.getUserName());
                    loggingDone = true;
                    logging = false;
                }
            } //if(1)


        }while (logging == true); // loop for logging

    }//layoutOfLoging

    // LayoutHowToPay method for how pay
    public static void LayoutHowToPay() {

        int choice;
        String strChoice, strChoice1 = "";
        Scanner sc = new Scanner(System.in);

        do { //(4)
            System.out.println("\nHow to pay:\n"
                    + "1) cash\n"
                    + "2) visa or credit card\n"
                    + "and any other number for nothing!");

            choice = sc.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("you pay cash!");
                    typeOfPay = "cash";
                    break;
                case 2:
                    System.out.println("you pay by visa or credit card!");
                    typeOfPay = "visa or credit card";
                    break;

                default:
                    System.out.println("You have to select one number from numbers between 1 to 2 !");
                    break;
            }

        } while (choice != 1 && choice != 2); //(4)
    }

}
