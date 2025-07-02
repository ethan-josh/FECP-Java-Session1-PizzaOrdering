package org.example;
import java.util.*;

public class Main {

    public static int inputQtyValidation(int checkInput){
        if (checkInput <= 0){
            Scanner userOption = new Scanner(System.in);
            while(checkInput <= 0){
                System.out.println("Quantity must be positive.");
                System.out.print("Quantity: ");
                checkInput = userOption.nextInt();
                System.out.println();
            }
        }
        return checkInput;
    }

    public static int inputIndexValidation(ArrayList<Integer> listToCheck, int checkInput){
        if (checkInput >= 0 && checkInput < listToCheck.size()) {
            // input is valid
            return checkInput+1;
        }
        if (listToCheck.isEmpty()){
            System.out.println("List is empty.");
            return 0;
        }

        if (checkInput < 0){
            Scanner userOption = new Scanner(System.in);
            while (checkInput < 0){
                System.out.println("Index must valid.");
                System.out.print("Index: ");
                checkInput = userOption.nextInt();
                System.out.println();
            }
        }
        if(checkInput >= listToCheck.size()){
            Scanner userOption = new Scanner(System.in);
            while (checkInput > listToCheck.size()){
                System.out.println("Index is out of bounds.");
                System.out.print("Index: ");
                checkInput = userOption.nextInt();
                System.out.println();
            }
        }
        return checkInput+1;

    }
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity){
        if (quantity > 0){
            pizzas.add(pizzaType);
            quantities.add(quantity);
        }
    }
    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity){
        if (quantities.isEmpty()){
            System.out.println("--- Invalid order number ---");
            System.out.println();
            //System.out.println(quantities.isEmpty());
        }
        else {
            if (newQuantity > 0) {
                quantities.set(index, newQuantity);
            }
        }
    }
    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index){
        if (quantities.isEmpty()){
            System.out.println("--- Invalid order number ---");
            System.out.println();
            //System.out.println(quantities.isEmpty());
        }
        else{
            pizzas.remove(index);
            quantities.remove(index);
        }

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
        int indexToUpdate; // int index

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

                    quantityToAdd = inputQtyValidation(quantityToAdd); // validate user input
                    addOrder(pizzas, quantities, typeOfPizza, quantityToAdd);
                    break;

                case 2:
                    System.out.print("Order number to update: ");
                    indexToUpdate = userOption.nextInt();
                    System.out.print("New quantity: ");
                    quantityToAdd = userOption.nextInt();
                    System.out.println();

                    indexToUpdate = inputIndexValidation(quantities, indexToUpdate-1);
                    quantityToAdd = inputQtyValidation(quantityToAdd); // validate user input
                    updateOrder(quantities,indexToUpdate-1, quantityToAdd);
                    break;
                case 3:
                    System.out.print("Order number to remove: ");
                    indexToUpdate = userOption.nextInt();

                    indexToUpdate = inputIndexValidation(quantities, indexToUpdate-1);
                    removeOrder(pizzas, quantities, indexToUpdate-1);
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