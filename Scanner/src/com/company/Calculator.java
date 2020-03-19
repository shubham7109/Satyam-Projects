package com.company;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Insert a number you would like to add");
        Scanner in = new Scanner(System.in);
        int a = Integer.parseInt(in.nextLine());
        System.out.println("Insert another number you would like to add");
        Scanner ib = new Scanner(System.in);
        int b = Integer.parseInt(ib.nextLine());    // at first i wrote this String s = in.nextLine(); but then the value of a number such as 5+8 came as 58 so when i changed it to int the compiler suggested me this  int b = Integer.parseInt(ib.nextLine()); and then it worked :)
        int c = a + b ;
        System.out.println(" The required number is " + c);

    }

}
