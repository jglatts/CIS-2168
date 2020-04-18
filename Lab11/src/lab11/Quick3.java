package lab11;

import java.util.Arrays;
import java.util.Random;

// Class Quick3. Provides static methods for sorting an integer array
// using 3-way quicksort. Performs better than 2-way quicksort when
// the array contains many duplicate elements.
public class Quick3 {

   private static Random random = new Random();
   private static int lowerThan, greaterThan;
   
   // Do not instantiate this class.
   private Quick3() { }

   // Rearranges the array in ascending order.
   public static void sort(int[] a) {
      sort(a, 0, a.length - 1);
   }

   // quicksort the subarray from a[lo] to a[hi]
   private static void sort(int[] a, int lo, int hi) {
      if (hi <= lo) return;
      int k = random.nextInt(hi - lo + 1) + lo;
      exch(a, lo, k);

      //COMMENT OR DELETE THE NEXT 3 LINES AND USE partition3() INSTEAD
      System.out.print("Shuffled Array: ");show(a);

      //YOUR CODE HERE. USE partition3()
      int[] m = partition3(a, lo, hi);
      // recursively sort the region to the left  of the middle region m
      // recursively sort the region to the right of the middle region m
      partition3(m, lo, lowerThan-1);   // sort left sub-array
      partition3(m, greaterThan+1, hi); // sort right sub-array
   }

   // partition2 the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
   // and return the index j.
   // YOU WILL NOT NEED partition2() IN YOUR FINAL SOLUTION. WRITE partition3() INSTEAD.
   private static int partition2(int[] a, int lo, int hi) {
      int i = lo;
      int j = hi + 1;
      int v = a[lo];   // the pivot - the leftmost element of a

      while (true) {
         // find item on lo to swap
         while (a[++i] < v) {
            if (i == hi) break;
         }
         // find item on hi to swap
         while ( v < a[--j]) {
            if (j == lo) break;      // redundant since a[lo] acts as sentinel
         }
         // check if pointers cross
         if (i >= j) break;

         exch(a, i, j);
      }

      // put partitioning item v at a[j]
      exch(a, lo, j);

      // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
      return j;
   }

   // THIS IS  THE METHOD THAT YOU NEED TO USE INSTEAD OF partition2()
   private static int[] partition3(int[] a, int lo, int hi) {
      //YOUR CODE HERE
      if (hi <= lo) return null;
      
      lowerThan = lo;
      greaterThan = hi;
      int i = lo;
      int pivot = a[lo]; 
      while (i <= greaterThan) {
          System.out.println("\nPivot is: " + pivot + " at index " + lo);
          System.out.print("Array is: ");show(a);
          if (a[i] < pivot) {
              System.out.println(a[i] + " < " + pivot);
              System.out.println("Exchanging " + a[lowerThan] + " and " + a[i]);
              exch(a, lowerThan, i);
              lowerThan++;
              i++;
          }
          else if (a[i] > pivot) {
              System.out.println(a[i] + " > " + pivot);
              System.out.println("Exchanging " + a[i] + " and " + a[greaterThan]);
              exch(a, i, greaterThan);
              greaterThan--;
          }
          else 
              ++i; // increase space for same values
      }
            
      return a;
   }

   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/

   // exchange a[i] and a[j]
   private static void exch(int[] a, int i, int j) {
      int swap = a[i];
      a[i] = a[j];
      a[j] = swap;
   }


   // print array to standard output
   private static void show(int[] a) {
      for (int i = 0; i < a.length; i++) {
         System.out.print(a[i] + " ");
      }
      System.out.println();
   }


   /**
    * Reads in a sequence of integers from standard input; quicksorts them,
    * and prints them to standard output in ascending order.
    */
   public static void main(String[] args) {
      // test quicksort with integers
      In in = new In("5ints.txt");
      int n = in.readInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
         a[i] = in.readInt();
      }
      Quick3.sort(a);
      show(a);
   }
}
