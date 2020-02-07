package labfour_partb;

import java.util.Arrays;

/**
 *
 * @author johng
 */
public class LabFour_PartB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();

        // ----------------- TEST ----------------- //
        System.out.println("\n\t--- BAG DATA TYPE TEST ---\n");

        String[] input = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        System.out.print(" Throwing the following items into a bag: ");
        System.out.println(Arrays.toString(input));

        // UNCOMMENT THE FOR LOOPS BELOW -- YOUR PROGRAM SHOULD WORK IF
        // YOUR IMPLEMENTATION OF THE ListIterator NESTED CLASS IS CORRECT
        for (String item : input) {
            bag.add(item);
        }

        System.out.println("\nBag size = " + bag.size() +". Printing bag contents (order irrelevant):\n");

        for (String s : bag) {
            System.out.println(s);
       }
    }    
}
