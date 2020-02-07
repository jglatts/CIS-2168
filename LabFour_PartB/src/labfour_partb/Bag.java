/******************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag
 *
 *  A generic bag or multiset, implemented using a singly linked list.
 *
 *  % java Bag
 * --- BAG DATA TYPE TEST ---
 *
 * Throwing the following items into a bag: [to, be, or, not, to, -, be, -, -, that, -, -, -, is]
 *
 * Bag size = 14. Printing bag contents (order irrelevant):
 *
 * is
 * -
 * -
 * -
 * that
 * -
 * -
 * be
 * -
 * to
 * not
 * or
 * be
 * to
 *
 ******************************************************************************/
package labfour_partb;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<E> implements Iterable<E> {
    private Node first;    // beginning of bag
    private int n;         // number of elements in bag

    // helper Node class (do not change).
    private class Node {
        private E item;
        private Node next;
    }

    // Initializes an empty bag (do not change).
    public Bag() {
        first = null;
        n = 0;
    }

    // Returns true if this stack is empty (no need to change).
    public boolean isEmpty() { return first == null; }

    // Returns the number of items in this stack (do not change).
    public int size() { return n; }

    // Adds the item to this bag (no need to change).
    public void add(E item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    // Returns an iterator that iterates over the items in the bag.
    public Iterator<E> iterator()  {
        return new ListIterator();
    }

    // THE FOLLOWING IS A NESTED CLASS. EDIT ITS CODE TO MAKE THIS FILE COMPILE
    // an iterator over a linked list
    private class ListIterator implements Iterator<E> {
        private Node current;

        // creates a new iterator
        public ListIterator() {
            current = first;
        }

        // is there a next item in the iterator?
        public boolean hasNext() {
            // YOUR CODE HERE. CHANGE THE RETURN STATEMENT.
            return current != null; // you only need to change this line
        }

        // this method is optional in Iterator interface (leave this unchanged)
        public void remove() {
            throw new UnsupportedOperationException();
        }

        // returns the next item in the iterator (and advances the iterator)
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            // YOUR CODE BELOW. YOU NEED AT MOST 3 LINES,
            // INCLUDING THE RETURN STATEMENT (WHICH YOU SHOULD CHANGE).
            E item = current.item; 
            current = current.next; 
            return item; 
        }
    }


    // Unit tests the Bag data type.
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