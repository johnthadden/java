//Arraylists and removing duplicates

import java.util.*;

class Main {
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>(list.size());
        for (E aList : list) {
            if (!newList.contains(aList)) {
                newList.add(aList);
            }
        }
        return newList;
    }
 
    public static void main( String args[] ) {
        Random rand = new Random();
        int upperbound = 21;
        int int_random = rand.nextInt(upperbound); 
        int i;
 
        ArrayList<Integer> originalList = new ArrayList<Integer>();
        ArrayList<Integer> finalList = new ArrayList<Integer>();
 
        for (i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(upperbound));
            Collections.sort(originalList);
        }
 
        try {
            System.out.println("The original list contains the following 50 values: " + originalList);
        }
        catch (Exception e) {
            System.out.println("Something went wrong in constructing the original array.");
        }
 
        originalList = removeDuplicates(originalList);
        for (Integer j : originalList) {
            finalList.add(j);
            Collections.sort(finalList);
        }
        
        try {
            System.out.println("The new list with all duplicates removed is: " + finalList);
        }
        catch (Exception e) {
            System.out.println("Something went wrong in constructing the new array.");
        }
    }
}
