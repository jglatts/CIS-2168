/**
 * Lab Answers
 * 
 * 3a) The if statement in the count() method gets executed n(n-1) / 2 times.
 * 
 * 3b) There are 66 pairs that sum to zero in 16Kints.txt.
 * 
 * 3c) The Big-O estimate for the count() method is O(n^2).
 * 
 */
package lab6;

import java.util.Arrays;
import java.util.Random;

public class TwoSum {
    
    private static final int MAXIMUM_INTEGER = 1000000;
    
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                if (a[i] + a[j] == 0) 
                    count++;
            }
        }
        return count;
    }
    
    public static void test8K() {
        In in = new In("16Kints.txt");
        int[] a = in.readAllInts();
        System.out.println("Original Array is: " + Arrays.toString(a));
        System.out.println("Count is: " + TwoSum.count(a));
    }
    
    public static void timeTrialTest() {
       for (int n = 250; n <= 512*250; n += n) {
         double time = timeTrial(n);
         System.out.printf("%7d %7.2f\n", n, time);
      }    
    }
    
   public static double timeTrial(int n) {
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
         a[i] = -MAXIMUM_INTEGER + 1 + new Random().nextInt(2* MAXIMUM_INTEGER - 1) ;
      }
      long startTime = System.currentTimeMillis();
      TwoSum.count(a);
      long endTime = System.currentTimeMillis();
      return (endTime - startTime)/1000;
   }    
    
    public static void main(String[] args) {
        timeTrialTest();
    }
    
}
