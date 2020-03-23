package com.company;

import java.util.Scanner;

public class AdvancedCalculator {

    public static void main(String[] args) {
        //TODO Required output:  10 - 5 = 5
        //TODO : Use only 1 scanner object

        int d= 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("If you would like to: \n add enter 1 \n subtract enter 2 \n multiply enter 3 \n divide enter 4  ");
            d = in.nextInt();
        }while (d < 1 || d > 4);
        // && = and
        // || = or

        switch (d) {
            case 1: {
                System.out.println("Insert a number you would like to add");
                int a = in.nextInt();
                System.out.println("Insert another number");
                int b = in.nextInt();
                int c = a + b;
                System.out.println(" The required number is " + c);
                System.out.println( a + " + " + b + " = " + c);
                break;
            }
            case 2: {
                System.out.println("Insert a number you would like to subtract");
                int a = in.nextInt();
                System.out.println("Insert another number");
                int b = in.nextInt();
                int c = a - b;
                System.out.println(" The required number is " + c);
                System.out.println( a + " - " + b + " = " + c);
                break;
            }
            case 3: {
                System.out.println("Insert a number you would like to multiply");
                int a = in.nextInt();
                System.out.println("Insert another number");
                int b = in.nextInt();
                int c = a * b;
                System.out.println(" The required number is " + c);
                System.out.println( a + " * " + b + " = " + c);
                break;
            }
            case 4: {
                System.out.println("Insert a number you would like to add");
                int a = in.nextInt();
                System.out.println("Insert another number you would like to add");
                int b = in.nextInt();
                int c = a / b;
                System.out.println(" The required number is " + c);
                System.out.println( a + " / " + b + " = " + c);
                break;

            }
        }

    }

    }
