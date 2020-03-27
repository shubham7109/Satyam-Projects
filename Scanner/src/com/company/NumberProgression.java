package com.company;

import java.util.Scanner;

public class NumberProgression {
    public static void main(String[] args) {
       System.out.println("How many digits would you want to print");
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int q = 1; q <= s; q = q + 1 ) {
            System.out.print(q + " ");
        }

    }



}
