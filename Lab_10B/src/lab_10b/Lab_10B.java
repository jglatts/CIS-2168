package lab_10b;

/**
 * @author johng
 */
public class Lab_10B {

    /**
     * Test Client
     * @param args 
     */
    public static void main(String[] args) {
        partOne();
        partTwo();
        partThree();
    }
    
    public static void partOne() {
        System.out.println("\n--------------Part1--------------\n");
        Exercise1Lab9.main(null);
    }
    
    public static void partTwo() {
        System.out.println("\n--------------Part2--------------\n");
        InversionsNaive.main(null);
        System.out.print("Number of inversions in the input sequence (using merge sort): "); 
        Inversions.main(null);    
    }
    
    public static void partThree() {
        System.out.println("\n--------------Part3--------------\n");
        Insertion.main(null);
        Merge.main(null);
    }
    
}