package com.company;
import javax.swing.table.TableRowSorter;
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
        System.out.println(errors);
        System.out.println(errorCalculation(errors,mean(errors)));
        System.out.println(absoluteError(errorCalculation(errors,mean(errors))));
        System.out.println(relativeError(absoluteError(errorCalculation(errors,mean(errors))), mean(errors)));
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
            errorCalculation.add(mean - error);
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
