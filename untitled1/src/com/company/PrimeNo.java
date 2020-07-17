package com.company;

public class PrimeNo {

    public static void main(String[] args) {

        System.out.println(isNumberPrime(7)); // Should print true

        System.out.println(isNumberPrime(10)); // Should print false

    }

    /**
     * Write a method to see if the given number is a
     * prime number or not.
     *
     * @param number Number to check if prime
     * @return True if the number is prime. False if the number is not prime.
     */
    public static boolean isNumberPrime(int number) {
        //TODO Fill out this method.
        int i;
        for (i = 1; i < 7; i++) {
            return number % i == 0;
        }
        return true;
    }
}

