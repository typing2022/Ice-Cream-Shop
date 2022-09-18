package Model;
import Service.DrinkService;
import Service.IceCreamService;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Drink extends Product{
    //first version of constructor
    public Drink(){}
    //second version of constructor
    public Drink(String name, double amount){
        this.name = name;
        this.amount = amount;

    }
    public Drink(int id,String name, double amount){
        this.id = id;
        this.name = name;
        this.amount = amount;

    }

    //Generate our Getters and Setters
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
     public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }


    @Override
    public String toString(){
        return "Drink name:     " + name  +  "  Amount: " + amount ;
    }

    //method for ordering drinks and return a list of drink object.
    @Override
    public ArrayList<Product> orderingItems() {
        //creating object of Scanner
        Scanner sc = new Scanner(System.in);

        //instance variables
        int choice;
        boolean ordering = false;

        do {//iterate for continue  ordering more than one drink

            DrinkService drinkList = new DrinkService();
            List<Drink> list1 = new ArrayList<>();

            list1 = drinkList.getAllDrinks();

            System.out.println("\nPlease select a drink:\n");

            //printing the list of drinks
            String str1 = "";
            for (Drink drink: list1 ){
                    str1 = str1 + drink.getId() + ")  " + drink.getName() + "\n" ;
            }

            System.out.println(str1);
            choice = sc.nextInt();

            //Creating and initializing Drink object
            Drink drink ;
            drink = drinkList.getDrinkById(choice);


            //Calling add method to add Drink object to the  products list
            products.add(drink);

            // New user interface
            System.out.println("=========================================================");
            System.out.println("\nDo you want another drink :\n"
                    + "1) yes\n"
                    + "2) no\n"
                    + "and any other number for nothing!");

            choice = sc.nextInt();

            if(choice == 1){
                ordering = true;
            }else {
                ordering = false;
            }
        } while(ordering == true) ;

        // return a list of products
        return products;

    }//orderingItems()



}
