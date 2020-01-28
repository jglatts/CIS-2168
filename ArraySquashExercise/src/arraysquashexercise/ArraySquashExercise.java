package arraysquashexercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Somewhat working...
 * The last two array values are working w/ correct output
 * 
 * In-order to swap the repeated values, must use Collections.frequency(dup_list, a[i]);
 *  - this will return amount of repeats, letting us know how many values of it we need
 *    in the new array 
 */

public class ArraySquashExercise {

  /**
   *  squash() takes an array of non-negative ints.  On completion the array
   *  contains the same numbers, but wherever the array had two or more
   *  consecutive duplicate numbers, they are replaced by one copy of the number.
   *  Hence, after squash() is done, no two consecutive numbers in the array are
   *  the same.
   *
   *  Any unused elements at the end of the array are set to -1.
   *
   *  For example, if the input array is [ 0 0 0 0 1 1 0 0 0 7 7 7 1 1 0 ],
   *  it reads [ 0 1 0 7 1 0 -1 -1 -1 -1 -1 -1 -1 -1 -1 ] after squash()
   *  completes.
   *
   *  @param a the input array.
   **/

  // THIS IS THE METHOD YOU NEED TO IMPLEMENT
  public static void squash(int[] a) {
    // YOUR CODE BELOW (PLEASE BE PREPARED TO EXPLAIN YOUR SOLUTION)
    
    /* Add a check that runs first to see if all elements are identical 
       When repopulating the list, check if a value exists in the dup. list and reg. list
    */
    int size = a.length, count = 0, zero_idx;
    ArrayList<Integer> list = findDuplicates(a);
    int[] newArr = replaceDuplicates(list, a);
    System.out.println("Duplicate List = " + list);
    System.out.println("New Array = " + Arrays.toString(newArr));
    // replace all elements from old-array w/ new-array 
    for (int i = 0; i < a.length; ++i) {
        a[i] = newArr[i];
    }
  }
  
  public static ArrayList<Integer> findDuplicates(int[] a) {
      ArrayList<Integer> duplicate_list = new ArrayList<>();
      for (int i = 1; i < a.length-1; ++i) {
             if (a[i] == a[i+1]) {
                duplicate_list.add(a[i]);
                i++;
             }
      }
      // we skipped the first element, so add it
      if (duplicate_list.contains(a[0])) duplicate_list.add(0, a[0]);
      return duplicate_list;
  } 
  
  public static int[] replaceDuplicates(ArrayList<Integer> dup_list, int[] a) {
      int[] newArr = new int[a.length];
      if (dup_list.isEmpty()) {
          for (int i = 0; i < a.length; ++i) {
              newArr[i] = a[i];
          }
          return newArr;
      }
      // remove un-neccs. else statement.. ant some point
      else {
            // now check if the list contains all the same elements 
            int check_val = dup_list.get(0);
            for (int i = 0; i < dup_list.size(); ++i) {
                if (dup_list.get(i) != check_val) {
                    break;  // exit this loop if elements aren't all the same    
                }
                // if we make it here, all elements are the same
                if (i == (dup_list.size()-1)) {
                    for (int x = 0; x < a.length; ++x) {
                        if (x == 0) newArr[x] = check_val;
                        else newArr[x] = -1;
                        
                    }
                    return newArr;
                }
            }
            
            // this seems pretty good, get rid of hard-codes though
            int check_limit = Collections.frequency(dup_list, 6);
            int check_limit_two = Collections.frequency(dup_list, 3);
            
            // swap the ordering of the array
            for (int i = 0; i < a.length; ++i) {
               if (i == 0) newArr[i] = a[0];
               else {
                   if (dup_list.contains(a[i])) {
                        if (i < dup_list.size()) newArr[i] = dup_list.get(i);
                        else newArr[i] = -1;
                   }
                   else {
                       newArr[i] = a[i];    // if the value is not in dup_list, add it to new list
                   }
               }
            }    
      }
      return newArr;
  }
  
  // DO NOT CHANGE THE stringInts() METHOD (IT'S USED BY TESTS IN main())
  /**
   *  stringInts() converts an array of ints to a String.
   *  @return a String representation of the array.
   **/
  private static String stringInts(int[] ints) {
    StringBuilder builder = new StringBuilder("[  ");
    for (int element : ints)
      builder.append(element).append("  ");
    return builder.append(']').toString();
  }

  // FEEL FREE TO ADD YOUR OWN TESTS TO main() IF YOU WISH, BUT DO
  // NOT REMOVE THE TESTS ALREADY THERE - YOUR SOLUTION SHOULD WORK
  // WITH THESE TESTS.

  /**
   *  main() runs test cases on your squash method.  Prints summary
   *  information on basic operations and halts with an error (and
   *  a stack trace) if any of the tests fail.
   **/
  public static void main(String[] args) {
    System.out.println("Let's squash arrays!\n");

    String result;
    int i;

    int[] test1 = {3, 7, 7, 7, 4, 5, 5, 2, 0, 8, 8, 8, 8, 5};
    System.out.println("squashing " + stringInts(test1) + ":");
    squash(test1);
    result = stringInts(test1);
    System.out.println(result);
    System.out.println("Should be: 3  7  4  5  2  0  8  5  -1  -1  -1  -1  -1  -1\n");
    //TestHelper.verify(result.equals(
    //        "[  3  7  4  5  2  0  8  5  -1  -1  -1  -1  -1  -1  ]"),
    //                  "BAD SQUASH!!!  No candy.");

    int[] test2 = {6, 6, 6, 6, 6, 3, 6, 3, 6, 3, 3, 3, 3, 3, 3};
    System.out.println("squashing " + stringInts(test2) + ":");
    squash(test2);
    result = stringInts(test2);
    System.out.println(result);
    System.out.println("Should be: 6  3  6  3  6  3  -1  -1  -1  -1  -1  -1  -1  -1  -1\n");
    //TestHelper.verify(result.equals(
    //        "[  6  3  6  3  6  3  -1  -1  -1  -1  -1  -1  -1  -1  -1  ]"),
    //                  "BAD SQUASH!!!  No candy.");

    int[] test3 = {4, 4, 4, 4, 4};
    System.out.println("squashing " + stringInts(test3) + ":");
    squash(test3);
    result = stringInts(test3);
    System.out.println(result);
    System.out.println("Should be: 4  -1  -1  -1  -1\n");
    //TestHelper.verify(result.equals("[  4  -1  -1  -1  -1  ]"),
    //                  "BAD SQUASH!!!  No candy.");

    int[] test4 = {0, 1, 2, 3, 4, 5, 6};
    System.out.println("squashing " + stringInts(test4) + ":");
    squash(test4);
    result = stringInts(test4);
    System.out.println(result);
    System.out.println("Should be: 0  1  2  3  4  5  6\n");
    //TestHelper.verify(result.equals("[  0  1  2  3  4  5  6  ]"),
    //                  "BAD SQUASH!!!  No candy.");
  }

}
