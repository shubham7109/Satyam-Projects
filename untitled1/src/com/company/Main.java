package com.company;

public class Main {

    public static void main(String[] args) {

        //Example
        multiplicationTable(2); //Prints the table of 2
        multiplicationTable(5); //Prints the table of 5
    }

    /**
     * Write a function that prints the multiplication table  of the number
     * Output:
     * 3 x 1 = 3
     * 3 x 2 = 6
     * 3 x 3 = 9
     * ..
     * ...
     * ....
     * 3 x 10 = 30
     * @param number The number of the table to print
     */
    public static void multiplicationTable(int number){
        //TODO write code here
        for (int x = 1; x < 11; x++) {
            System.out.println(number + " x " + x + " = " + number * x);
        }
    }
}

