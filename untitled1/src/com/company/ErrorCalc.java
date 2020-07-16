package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class ErrorCalc {
    public static void main(String[] args) {
        System.out.println("Enter number of observations");
        Scanner in = new Scanner(System.in);
        int numberObservations = in.nextInt();
        int i;
        ArrayList<Float> errors = new ArrayList<>();
        for ( i = 1 ; i <= numberObservations ; i++) {
            System.out.println("Enter value of " + i + " observation");
            errors.add(in.nextFloat());
        }
        System.out.println("True value is "+ errors);
        System.out.println("Absolute errors are "+errorCalculation(errors,mean(errors)));
        System.out.println("Mean absolute error is "+ (absoluteError(errorCalculation(errors,mean(errors)))));
        System.out.println("Relative error is "+relativeError(absoluteError(errorCalculation(errors,mean(errors))), mean(errors)));
        float percentageError = Math.abs(relativeError(absoluteError(errorCalculation(errors,mean(errors))), mean(errors)) * 100);
        System.out.println("The result is (percentage error)" + mean(errors) + " +/- " + percentageError);
        System.out.println("The result is " + mean(errors) + " +/- " + absoluteError(errorCalculation(errors,mean(errors))));
        }
    public static float mean(ArrayList<Float> errors){
        float sum = 0;
        for (Float error : errors) {
            sum = sum + error;
        }
        return sum / errors.size();
    }
    public static ArrayList<Float> errorCalculation(ArrayList<Float> errors, float mean) {
        ArrayList<Float> errorCalculation = new ArrayList<>();
        for (Float error : errors)
            errorCalculation.add(Math.abs((mean) - (error)));
        return errorCalculation;
    }
    public static float absoluteError(ArrayList<Float> errorCalculation){
        float sum = 0;
        for (Float aFloat : errorCalculation) {
            sum = sum + aFloat;
        }
        return sum / errorCalculation.size();
    }
    public static float relativeError(float absoluteError, float mean) {
        return absoluteError/mean;
    }
}
