/* Prompts for assignment:
Write a test program that stores 50,000 integers in LinkedList and test the time to traverse the list using an iterator vs. using the get(index) method.
Then, test your program storing 500,000 integers.

Result is below: */

import java.util.*;
import java.time.*;

class Main {
      public static void main( String args[] ) {
      GetTest1 object1 = new GetTest1();
      GetTest2 object2 = new GetTest2();
      IterationTest1 object3 = new IterationTest1();
      IterationTest2 object4 = new IterationTest2();

      long start1 = System.nanoTime();
      object1.test1();
      long end1 = System.nanoTime();

      long start2 = System.nanoTime();
      object2.test2();
      long end2 = System.nanoTime();

      long start3 = System.nanoTime();
      object3.test3();
      long end3 = System.nanoTime();

      long start4 = System.nanoTime();
      object4.test4();
      long end4 = System.nanoTime();

      try {
        System.out.println("Using the 'get(index)' method on a LinkedList of 50,000 integers took " + (end1-start1) + " nanoseconds.");
        System.out.println("Using the 'get(index)' method on a LinkedList of 500,000 integers took " + (end2-start2) + " nanoseconds.");
        System.out.println("Iterating through a LinkedList of 50,000 integers took " + (end1-start1) + " nanoseconds.");
        System.out.println("Iterating through a LinkedList of 500,000 integers took " + (end2-start2) + " nanoseconds.");
      }
      catch (Exception e) {
        System.out.println("Something went wrong. Please try again.");
      }

    }
}
class GetTest1  {

     public void test1(){
      Random rand = new Random();
      int upperbound = 10;
      int int_random = rand.nextInt(upperbound); 
      int i;
      LinkedList<Integer> list = new LinkedList<Integer>();
      for (i = 0; i < 50000; i++) {
          list.add(rand.nextInt(upperbound));
          System.out.println(list.get(i));
      }
   }
}

class GetTest2 {
      public void test2(){
      Random rand = new Random();
      int upperbound = 10;
      int int_random = rand.nextInt(upperbound); 
      int i;
      LinkedList<Integer> list = new LinkedList<Integer>();
      for (i = 0; i < 500000; i++) {
          list.add(rand.nextInt(upperbound));
          System.out.println(list.get(i));
      }
   }
}

class IterationTest1 {
      public void test3(){
      Random rand = new Random();
      int upperbound = 10;
      int int_random = rand.nextInt(upperbound); 
      int i;
      LinkedList<Integer> list = new LinkedList<Integer>();
      Iterator it = list.iterator();

      while(it.hasNext()) {
        System.out.println(it.next());
      }
   }
}

class IterationTest2 {
      public void test4(){
      Random rand = new Random();
      int upperbound = 10;
      int int_random = rand.nextInt(upperbound); 
      int i;
      LinkedList<Integer> list = new LinkedList<Integer>();
      Iterator it = list.iterator();

      while(it.hasNext()) {
        System.out.println(it.next());
      }
   }
}

/*Both LinkedLists were still iterated through extremely fast (under a quarter of a second).
The list with ten times as many integers generally took roughly five to ten times longer
than the smaller list, which is to be expected with ten times the number of integers to
iterate through. What's interesting is that both the 'get(index)' method and just iterating through took EXACTLY the same amount of time!*/
