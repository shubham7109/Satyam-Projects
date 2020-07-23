package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contains {

    public static void main(String[] args) {
        //Don't worry if this looks confusing
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 4, 5)); //This list has some duplicates to remove
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,5));           //This has no duplicates, so it shouldn't remove anything
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1,1));     //This should remove all except 1 item.

        //Output
        System.out.println(removeDuplicates(list1)); //Output: 1,2,3,4,5
        System.out.println(removeDuplicates(list2)); //Output: 1,2,3,4,5
        System.out.println(removeDuplicates(list3)); //Output: 1

    }

    private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> numbers){
        ArrayList<Integer> noDuplicates = new ArrayList<>();
        for (Integer number : numbers) {
            if (!noDuplicates.contains(number)) {
                noDuplicates.add(number);
                noDuplicates.add(1);
            }
        }
        //TODO Fill this method
        // Hint: use ArrayList.contains() somewhere
        return noDuplicates;
    }

}
