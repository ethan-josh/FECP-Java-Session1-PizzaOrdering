package org.example;
import java.util.*;

public class Main {
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity){
        pizzas.add(pizzaType);
        quantities.add(quantity);
    }
    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity){

    }
    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index){

    }
    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities){
        System.out.println("--- Current Orders ---");
        for (int i = 0; i < pizzas.size(); i++){
            System.out.printf("%d. " + pizzas.get(i) + " x " + quantities.get(i), i+1);
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<String> pizzas = new ArrayList<String>(); // ArrayList<String> pizzas
        ArrayList<Integer> quantities = new ArrayList<Integer>(); // ArrayList<Integer> quantities
        Scanner myObj = new Scanner (System.in);

        // String typeOfPizza; // String pizzaType
        int quantityToAdd; // int quantity

        int userChoice = 0;
        // User menu
        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Order");
        System.out.println("5. Exit");

        // Loop choose option
        while (userChoice != 5) {
            Scanner userOption = new Scanner (System.in);
            System.out.print("Choose option: ");
            userChoice = myObj.nextInt();

            switch (userChoice){
                case 1:
                    System.out.print("Pizza type: ");
                    String typeOfPizza = userOption.next();
                    System.out.print("Quantity: ");
                    quantityToAdd = userOption.nextInt();
                    System.out.println();

                    if (quantityToAdd <= 0){
                        while(quantityToAdd <= 0){
                            System.out.println("Quantity must be positive");
                            System.out.print("Quantity: ");
                            quantityToAdd = userOption.nextInt();
                            System.out.println();
                        }
                    }
                    addOrder(pizzas, quantities, typeOfPizza, quantityToAdd);
                    break;

                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    System.out.println();
                    printOrders(pizzas, quantities);
                    break;
                case 5:
                    break;
            }
        }

        System.out.println("---Thank you!---");

    }
}