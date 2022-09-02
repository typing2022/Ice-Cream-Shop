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
    //public void setName(String name){
     //   this.name = name;
   // }
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }

    //method for printing drink object data.
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
            //do{//iterate for checking that a customer selected  one number between 1 : 4 only

                DrinkService drinkList = new DrinkService();
                List<Drink> list1 = new ArrayList<>();

                list1 = drinkList.getAllDrinks();

                System.out.println("\nPlease select a drink:\n");

                String str1 = "";
                for (Drink drink: list1 ){
                    str1 = str1 + drink.getId() + ")" + drink.getName() + "\n" ;
                }
                System.out.println(str1);

                choice = sc.nextInt();


           // } while(choice != 1 && choice != 2 & choice != 3 & choice != 4);

            Drink drink = new Drink();
            drink = drinkList.getDrinkById(choice);

            //creating drink object
            //Drink drink = new Drink(id,name,amount);
            //call add method to add drink oject to products list
            products.add(drink);

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
        // return list of products
        return products;

    }//orderingItems()



}
