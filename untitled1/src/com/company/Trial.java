package com.company;

import java.util.Scanner;

public class Trial {
    static boolean even(int x) {
        return x % 2 == 0;
       }
       public static void main(String[] args) {
           System.out.println("Enter an integer to check if it's odd or even");
           Scanner in = new Scanner(System.in);
           int number = in.nextInt();
           System.out.println(even(number));
      }
}