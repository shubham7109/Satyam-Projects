package com.company;

import java.util.Scanner;

public class Function {


    public static void main(String[] args) {

        // Learn aboutJava Functions! https://www.w3schools.com/java/java_methods.asp

        //TODO
        // Write a code prints "Enter your name:" using a printQuestion() function
        // Enter your name using scanner using a getName() function. getName() function should return a String
        // Store the returned name in a String variable
        // Print out: "Hello, NAME" using the variable in the main() function.
        printQuestion ();
        getName ();



        //Here is some starter code for the functions you will use below. Good luck!

    }

    static void printQuestion(){
        //TODO, fill this in
        System.out.println("Enter your name");

    }

    static void getName(){
        //TODO, fill this in
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println("Hello, " + a);
    }

}
