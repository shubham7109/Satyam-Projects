package com.company;

import java.util.Scanner;

public class Function {


    public static void main(String[] args) {

        // Learn aboutJava Functions! https://www.w3schools.com/java/java_methods.asp


        //TODO
        // Write a code prints "Enter your name:" using a printQuestion() function
        // Enter your name using scanner using a getName() function. getName() function should return a String
        // Store the returned name in a String variable
        // Print out: "Hello, NAME" using the variable in the helloMessage() function.

        printQuestion();
        getName();
        helloMessage();


    }

    private static void helloMessage() {
        //TODO
        // Print the hello message by retrieving the name as a parameter/argument
        System.out.println("Hello, " + a);
    }

    static void printQuestion(){
        //TODO
        // Print the question "Enter you name" that is it :)
        System.out.println("Enter your name");


    }

    static void getName(){
        //TODO
        // This function should not print anything
        // This function should get the name using scanner and then return the String back to main.
        Scanner in = new Scanner(System.in);
        String a = in.next();
    }

}
