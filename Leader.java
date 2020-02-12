public class Leader {
    private Node head = null, tail = null;
    private int n, m;
    
    /**
     * Construct a new list object containing all the players
     * 
     * @param n, amount of people in circle
     * @param m, every m-th person to eliminate
     */
    public Leader(int n, int m) {
        this.n = n;
        this.m = m;
        this.fillList();
    }
    
    /**
     * Node helper class 
     */
    private static class Node {
        private int item;
        private Node next;
        private Node(int item) { this.item = item; }
    }
    
    /**
     * Fill the list with players
     */
    private void fillList() {
        this.head = new Node(1); 
        this.tail = head; 
        for(int i = 2; i <= n; i++) {
            // link nodes together
            tail.next = new Node(i); 
            tail = tail.next; 
        }     
        tail.next = head;   // wire the tail-node back to head-node
    }
    
    /**
     * Find the leader
     */
    public void findLeader() {
        Node pointerOne = head, pointerTwo = head;
        while (pointerOne.next != pointerOne) {
            int count = 1; 
            while(count != m) { 
                // this increments the pointerOne pointer 1 player a time
                // pointerTwo is set to the last element,
                // so when we delete it, we can use it's next Node
                pointerTwo = pointerOne; 
                pointerOne = pointerOne.next; 
                count++; 
            }
            System.out.println(pointerOne.item);
            // delete the value and re-wire the pointer from pointerTwo
            pointerTwo.next = pointerOne.next; 
            // set pointerOne to the next value
            pointerOne = pointerTwo.next;
        }
        System.out.println("leader: " + pointerOne.item);
    }
    
    /* Driver method */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // n: total number of people
        int m = Integer.parseInt(args[1]);// m-th person is eliminated at each round
        
        // YOUR SOLUTION GOES HERE (Note: if you use a suitable data structure,
        // you can write a solution in under 10 lines of code.)
        Leader leaderList = new Leader(n, m);
        leaderList.findLeader();
    }    
    
}
