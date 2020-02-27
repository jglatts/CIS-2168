/**
 * Lab Answers
 * 
 * 1a) There are 4039 triples that sum to zero in 4Kints.txt.
 *
 * ---This is C(n, 3)---
 * 1b) The if statement in the count() method gets executed
 *     n(n-1)(n-2) / 3 times. 
 */
package lab6;

import java.util.Arrays;

public class ThreeSum {
    
   public static int count(int[] a) {
      int n = a.length;
      int count = 0;
      for (int i = 0; i < n; i++) {
         for (int j = i+1; j < n; j++) {
            for (int k = j+1; k < n; k++) {
               if (a[i] + a[j] + a[k] == 0)
                  count++;
            }
         }
      }
      return count;
   }

   public static void main(String[] args) {
      In in = new In("8Kints.txt"); 
      int[] a = in.readAllInts();
      System.out.println("The original array of ints: " + Arrays.toString(a));
      long startTime = System.currentTimeMillis();
      System.out.println("Count is: " + ThreeSum.count(a));
      long endTime = System.currentTimeMillis();
      long timeElapsed = endTime - startTime;
      System.out.println("Execution time in milliseconds  : " + timeElapsed);
   }
   
}
