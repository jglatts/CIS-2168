/******************************************************************************
 *  Compilation:  javac LinkedStack.java
 *  Execution:    java LinkedStack
 *
 *  A generic stack, implemented using a singly linked list.
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
import java.util.NoSuchElementException;

public class LinkedStack<E> {
    private Node<E> first;     // top of stack
    private int size;          // size of the stack

    // helper Node class (do not change).
    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    // Initializes an empty stack (do not change).
    public LinkedStack() {
        first = null;
        size = 0;
    }

    //Returns true iff this stack is empty (no need to change).
    public boolean isEmpty() {
        return first == null;
    }

    // Returns the number of items in this stack (do not change).
    public int size() {
        return size;
    }

    // Adds the item to this stack.
    public void push(E item) {
        Node<E> oldfirst = first;
        // YOUR CODE BELOW (at most 3 lines)
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    // Removes and returns the item most recently added to this stack.
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        // YOUR CODE BELOW (at most 2 lines)
        E value = first.item;
        first = first.next;
        size--;
        return value; // return the saved item        
    }

    // Returns a string representation of this stack (no need to change this method).
        public String toString() {
            StringBuilder s = new StringBuilder();
            Node<E> current = first;
            while ( current != null ) {
                s.append("\t" + current.item + "\n");
                current = current.next;
            }
            return s.toString();
        }

    // Unit tests the LinkedStack data type (similar to the FixedSizeArrayStack tests).
    // THIS FILE WILL RUN AS-IS BUT WILL PRODUCE INCORRECT OUTPUT.
    // YOUR JOB IS TO MAKE THE OUTPUT MATCH THE OUTPUT FOUND IN THE INSTRUCTIONS.
    public static void main(String[] args) {
        // ----------------- TEST 1 ----------------- //
        System.out.println("\n\t--- TEST 1 ---\n");

        String[] input = {"it", "was", "the", "best", "of", "times"};
        System.out.print("Items that will be pushed into the stack are: ");
        System.out.println(Arrays.toString(input));

        LinkedStack<String> stack = new LinkedStack();
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
        stack = new LinkedStack();
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
