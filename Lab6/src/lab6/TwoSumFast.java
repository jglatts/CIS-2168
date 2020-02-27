/**
 * Lab Answers
 * 
 * 4a) The time complexity of the count method in TwoSumFast is O(nlogn)).
 * 
 * 4b) There are 249838 pairs on integer that sum to zero in the 1Mints.txt file.
 * 
 */
package lab6;

import java.util.Arrays;
import java.util.Random;

public class TwoSumFast {

    private static final int MAXIMUM_INTEGER = 1000000;
    private static final int ARRAY_SIZE = 1048576;
       
    public static int count(int[] a) {
        Arrays.sort(a); // O(nlogn)
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (BinarySearch.indexOf(a, -a[i]) > i) count++;
        }
    return count;
}
    
    public static void main(String[] args) {
        timeTrialTest();
        //twoSumFastTest();
    }
    
    public static void twoSumFastTest() {
         // 1 million int array
        // Run the various sized Array with this guy
        //In in = new In("https://gist.githubusercontent.com/david-dobor/b8548ad959c016b621c1790830de534b/raw/df5ff220f74dad6e803055207121eecc8c01d418/1Mints.txt");
        In in = new In("8Kints.txt");
        int[] a = in.readAllInts();
        System.out.println("Original Array is: " + Arrays.toString(a));
        System.out.println("Count is: " + TwoSumFast.count(a));
    }
    
    public static void timeTrialTest() {
       for (int n = 250; n <= ARRAY_SIZE*250; n += n) {
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
      TwoSumFast.count(a);
      long endTime = System.currentTimeMillis();
      return (endTime - startTime)/1000;
   }    
    
}
