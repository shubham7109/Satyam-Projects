package com.company;

import java.util.Scanner;

public class Methods {

    static  void myMethod1() {
        System.out.println("Yow will have a good day");
    }

    static void myMethod2() {
        System.out.println("You will be lucky");
    }

    static void myMethod3() {
        System.out.println("You will be unlucky");
    }

}

    public static void main(String[] args) {
        System.out.println("Choose a number between 0 and 4");
        Scanner in = new Scanner(System.in);
        int answer;
        answer = in.nextInt();
        switch (answer) {
           case (1):
                myMethod1();
           case (2):
                myMethod2();
           case (3):
                myMethod3();
                break;
        }
    }
}





