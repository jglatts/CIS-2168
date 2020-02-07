/******************************************************************************
 *  Compilation:  javac FixedSizeArrayStack.java
 *  Execution:    java FixedSizeArrayStack
 *
 *  A generic stack, implemented using an array.
 *  Each stack element is of type E.
 *
 *  In this demo, the test 1 in main() reads in a String array (instead of reading
 *  a file from standard input) and pushes each element of the array onto the
 *  stack. It then prints the stack from top to bottom.
 *
 *  What does test 2 do?
 *
 ******************************************************************************/
package labfour_partb;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
    2/6/20 Working
*/


public class FixedSizeArrayStack<E> implements Iterable<E> {
    private E[] a;         // array of items
    private int n;         // number of elements on stack
    

    // Initializes an empty stack.
    // An array that backs this stack implementation has 100 elements.
    // If the capacity is exceeded, ArrayIndexOutOfBoundsException will be thrown.
    // Later, we'll do a "resizing array" implementation that doesn't suffer from this flaw.
    public FixedSizeArrayStack() {
        a = (E[]) new Object[100];
        n = 0;
    }

     // return true if this stack is empty; false otherwise (no need to change).
    public boolean isEmpty() { return n == 0; }

    // Returns the number of items in this stack (do not change).
    public int size() { return n; }


    // Adds the item to this stack (change this method).
    public void push(E item) {
        // YOUR CODE BELOW. YOU ONLY NEED ONE OR TWO LINES.
        a[n++] = item;
    }


    // Removes and returns the item most recently added to this stack (change this method).
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        // YOUR CODE BELOW. YOU ONLY NEED TWO-THREE LINES.
        E item = a[n-1];
        a[n--] = null;
        // change the return statement -- it should return the popped item
        return item;                
    }

    // Returns an iterator to this stack that iterates through the items in LIFO order.
    // Leave this method unchanged - you certainly do need it (why?).
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    // NO NEED TO CHANGE THE FOLLOWING NESTED CLASS OR THE toString() METHOD BELOW IT.
    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<E> {
        private int i;

        public ReverseArrayIterator() {
            i = n-1;
        }

        public boolean hasNext() {
            return i >= 0;
        }   

        // do not change method remove()
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }

    }
    // Returns a string representation of this stack.
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E e : this) {
            s.append("\t" + e + "\n");
        }
        return s.toString();
    }


    // Unit tests the FixedSizeArrayStack data type (similar to the LinkedStack tests).
    // THIS FILE WILL RUN AS-IS BUT WILL PRODUCE INCORRECT OUTPUT.
    // YOUR JOB IS TO MAKE THE OUTPUT MATCH THE OUTPUT FOUND IN THE INSTRUCTIONS.
    public static void main(String[] args) {

        // ----------------- TEST 1 ----------------- //
        System.out.println("\n\t--- TEST 1 ---\n");

        String[] input = {"it", "was", "the", "best", "of", "times"};
        System.out.print("Items that will be pushed into the stack are: ");
        System.out.println(Arrays.toString(input));

        // UNCOMMENT THE FOLLOWING LINES -- YOUR PROGRAM SHOULD NOW WORK
        FixedSizeArrayStack<String> stack = new FixedSizeArrayStack();
        for (String item : input) {
            stack.push(item);
        }
        System.out.println("\nStack size = " + stack.size() +". Stack items from top to bottom are:\n");

        System.out.println(stack);

        // ----------------- TEST 2 ----------------- //
        System.out.println("\n\n\t--- TEST 2 ---\n");
        String[] input2 = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        System.out.print("Items that will be processed are:  ");
        System.out.println(Arrays.toString(input2));
        System.out.println();
        System.out.println("Process these items one at a time (from left to right) and ");
        System.out.println("  -- push an item onto a stack unless the item is a hyphen ('-');" );
        System.out.println("  -- if an item is a hyphen, pop the most recently added item.");

        System.out.println("\nThese are the popped items:");
        stack = new FixedSizeArrayStack();
        for (String item : input2) {
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                System.out.print(stack.pop() + " ");
        }
        System.out.println("\n\n(" + stack.size() + " left on stack)");
        System.out.println("\n" + stack);
    }
}