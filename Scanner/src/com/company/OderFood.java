package com.company;

import java.util.Scanner;

public class OderFood {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please input total balance");

        float balance = in.nextFloat();
        float checkoutbalance = 0;
        int item;

        do {
        System.out.println("Choose which items to add to cart");
        System.out.println("1. Burrito: $5");
        System.out.println("2. Taco: $3");
        System.out.println("3. Sandwich: $10");
        System.out.println("4. Pasta: $6");
        System.out.println("5. Coke: $1");
        System.out.println("6. Checkout");
        System.out.println("Select which item to add to cart: ");
        item = in.nextInt();
        switch (item) {
            case 1:
                checkoutbalance += 5;
                System.out.println("Burrito has been added to your cart, Cart total is " + checkoutbalance + "Dhs");
                break;
            case 2:
                checkoutbalance += 3;
                System.out.println("Taco has been added to your cart, Cart total is " + checkoutbalance + "Dhs");
                break;
            case 3:
                checkoutbalance += 10;
                System.out.println("Sandwich has been added to your cart, Cart total is " + checkoutbalance + "Dhs");
                break;
            case 4:
                checkoutbalance += 6;
                System.out.println("Pasta has been added to your cart, Cart total is " + checkoutbalance + "Dhs");
                break;
            case 5:
                checkoutbalance += 1;
                System.out.println("Coke has been added to your cart, Cart total is " + checkoutbalance + "Dhs");
                break;
            case 6:
                float finalbalance;
                if (checkoutbalance <= balance) {
                    finalbalance = balance - checkoutbalance;
                    System.out.println("Total cart ammount is " + checkoutbalance + "Dhs \nTotal Balance entered is " + balance + "Dhs \nTo proceed with transaction enter 7 \nTo cancel transaction enter 8 ");
                    float conformation = in.nextInt();
                    if (conformation == 7){
                        System.out.println("Transaction completed, Remaining balance is " + finalbalance + "Dhs");
                    } else { System.out.println("Transaction Cancelled !");}
                } else {
                    System.out.println("Insufficient Funds !");
                }
                break;
        }
        }while (item != 6);
    }
}

