package Model;
import Service.IceCreamService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IceCream extends Product {

    //first version of constructor
    public IceCream(){};

    public IceCream(String name, double amount){
        this.name = name;
        this.amount = amount;


    }

    //second version of constructor
    public IceCream(int id,String name, double amount){
        this.name = name;
        this.amount = amount;
        this.id = id;

    }

    //Generating  Getters and Setters
    public int getId(){ return  this.id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getAmount (){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }

    @Override
    public String toString(){
        return "Ice Cream name: " + name  +   "    Amount:" + amount ;
    }

    @Override
    public ArrayList<Product> orderingItems() {
        Scanner sc = new Scanner(System.in);
        int  choice;
        boolean ordering = false;
        System.out.println();

        do{//iterate  to order  more than one ice cream

            IceCreamService iceCreamList = new IceCreamService();
            List<IceCream> list = new ArrayList<>();

            list = iceCreamList.getAllIceCreams();

            System.out.println("\nPlease select one  ice cream:\n");
            String str = "";
            for (IceCream ice: list ){
                 str = str + ice.getId() + ")   " + ice.getName() + "\n" ;
            }
            System.out.println(str);

            choice = sc.nextInt();

            //Creating and initializing IceCream object
            IceCream ice ;
            ice = iceCreamList.getIceCreamById(choice);

            //Adding IceCream object to products list
            products.add( ice);
//...................................................................................
            System.out.println("==========================================================");
            System.out.println("\nDo you want another ice cream :\n"
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


    }// orderingItems


}
