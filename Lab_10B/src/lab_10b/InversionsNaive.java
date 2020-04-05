package lab_10b;

import java.util.Arrays;

public class InversionsNaive {

   private static long getInversionCount(int[] a, int[] aux, int left, int right) {
      long numberOfInversions = 0;
      for (int i = 0; i < a.length; i++) {
         for (int j = i + 1; j < a.length; j++) {
            if (a[i] > a[j])
               numberOfInversions++;
         }
      }
      return numberOfInversions;
   }

   public static void main(String[] args) {
      //In in = new In("100Kints.txt");
      In in = new In("8ints.txt");
      int n = in.readInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
         a[i] = in.readInt();
      }
      //System.out.println(Arrays.toString(a));
      int[] aux = new int[n];
      System.out.println("Number of inversions in the input sequence: " +
            getInversionCount(a, aux, 0, a.length-1));
   }

}
