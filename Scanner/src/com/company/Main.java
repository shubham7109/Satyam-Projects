package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("What is your name?");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println("Your Name is " + s);
        

    }
}