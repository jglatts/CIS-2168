package lab6;

public class Lab6 {
    
    public static void main(String[] args) {
        // testing all Classes
        /*
        ThreeSum.main(args);
        System.out.println();
        DoublingTest.main(args);
        System.out.println();
        TwoSum.main(args);
        System.out.println();
        */
        System.out.println("O(n^2) run-time:");
        TwoSum.main(args);
        System.out.println("\nO(nlogn) run-time:");
        TwoSumFast.main(args);
    }
      
}
