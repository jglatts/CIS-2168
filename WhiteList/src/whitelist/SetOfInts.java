package whitelist;

import java.util.Arrays;

public class SetOfInts {
   private int[] a;

   public SetOfInts(int[] keys) {
      a = new int[keys.length];
      for (int i = 0; i < keys.length; i++)
         a[i] = keys[i]; // defensive copy
      Arrays.sort(a);
   }

   public boolean contains(int key) { return indexOf(key) != -1; }

   private int indexOf(int key) {
      // YOUR JOB: REPLACE THE NEXT 5 LINES WITH YOUR OWN CODE
      return indexOfLinear(key);
   }
   
   /**
    *  Iterative binary search implementation
    *  Takes around 7-10 seconds to execute , 0(logN) 
    * 
    * @param key, the account key to locate
    * @return the index of the account, or -1 if it DNE
    */
   private int indexOfIterate(int key) {
      int hi = a.length - 1;
      int lo = 0;
      
      while (hi >= lo) {
          int mid = lo + (hi - lo) / 2;
          if (a[mid] == key) return mid;
          if (key < a[mid]) hi = mid - 1;
          else lo = mid + 1;
      }
      
      return -1;
   }
   
    /**
    *  Recursive binary search implementation
    *  Takes around 7-10 seconds to execute , 0(logN) 
    * 
    * @param hi, the starting right position, e.g a.length-1
    * @param lo, the starting left position, e.g 0
    * @param key, the account key to locate
    * @return the index of the account, or -1 if it DNE
    */
   private int indexOfRecursive(int hi, int lo, int key) {
        if (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) return mid;
            if (key > a[mid]) return indexOfRecursive(hi, mid + 1, key);
            else return indexOfRecursive(mid-1, lo, key);     
        }
        return -1;
   }
   
    /**
    *  Linear search implementation
    *  Takes around 6 minutes to execute , 0(N) 
    * 
    * @param key, the account key to locate
    * @return the index of the account, or -1 if it DNE
    */
   public int indexOfLinear(int key) {
       for (int i = 0; i < a.length; ++i) {
           if (key == a[i]) return i;
       }
       return -1;
   }
}

