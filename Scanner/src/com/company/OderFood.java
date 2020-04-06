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
        } while (item != 6);

        switch (item) {
                case 1:
                    checkoutbalance += 5;
                    break;
                case 2:
                    checkoutbalance += 3;
                    break;
                case 3:
                    checkoutbalance += 10;
                    break;
                case 4:
                    checkoutbalance += 6;
                    break;
                case 5:
                    checkoutbalance += 1;
                    break;
                case 6:
                    float finalbalance = balance - checkoutbalance;
                    System.out.println(finalbalance);
                    break;
            }
    }
}

