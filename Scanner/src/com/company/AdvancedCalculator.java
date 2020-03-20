package com.company;

import java.util.Scanner;

public class AdvancedCalculator {
    public static void main(String[] args) {
        System.out.println("If you would like to: \n add enter 1 \n subtract enter 2 \n multiply enter 3 \n divide enter 4  ");
        Scanner in = new Scanner(System.in);
        String d = in.nextLine();
        if (d.equals("1")) {
            System.out.println("Insert a number you would like to add");
            Scanner ir = new Scanner(System.in);
            int a = Integer.parseInt(in.nextLine());
            System.out.println("Insert another number");
            Scanner ib = new Scanner(System.in);
            int b = Integer.parseInt(ib.nextLine());
            int c = a + b ;
            System.out.println(" The required number is " + c);
        } else if (d.equals("2")) {
            System.out.println("Insert a number you would like to subtract");
            Scanner ir = new Scanner(System.in);
            int a = Integer.parseInt(in.nextLine());
            System.out.println("Insert another number");
            Scanner ib = new Scanner(System.in);
            int b = Integer.parseInt(ib.nextLine());
            int c = a - b ;
            System.out.println(" The required number is " + c);
        } else if (d.equals("3")) {
            System.out.println("Insert a number you would like to multiply");
            Scanner ir = new Scanner(System.in);
            int a = Integer.parseInt(in.nextLine());
            System.out.println("Insert another number");
            Scanner ib = new Scanner(System.in);
            int b = Integer.parseInt(ib.nextLine());
            int c = a * b ;
            System.out.println(" The required number is " + c);
        } else if (d.equals("4")) {
            System.out.println("Insert a number you would like to add");
            Scanner ir = new Scanner(System.in);
            int a = Integer.parseInt(in.nextLine());
            System.out.println("Insert another number you would like to add");
            Scanner ib = new Scanner(System.in);
            int b = Integer.parseInt(ib.nextLine());
            int c = a / b ;
            System.out.println(" The required number is " + c);

        }

    }

    }
