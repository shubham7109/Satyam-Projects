package com.company;

import java.util.Scanner;

public class OderFood {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input total balance");
        float balance = in.nextFloat();
        float checkoutbalance = 0;

        System.out.println("Choose which items to add to cart");
        System.out.println("1. Burrito: $5");
        System.out.println("2. Taco: $3");
        System.out.println("3. Sandwich: $10");
        System.out.println("4. Pasta: $6");
        System.out.println("5. Coke: $1");
        System.out.println("6. Checkout");
        System.out.println("Select which item to add to cart: ");
        int item = in.nextInt();
        switch (item) {
            case 1: checkoutbalance = 5;
            case 2: checkoutbalance = 3;
            case 3: checkoutbalance = 10;
            case 4: checkoutbalance = 6;
            case 5: checkoutbalance = 1;
            case 6: float finalbalance = balance - checkoutbalance;
                    System.out.println(checkoutbalance);


        }
    }
}

