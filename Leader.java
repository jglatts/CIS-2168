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
        fillList();
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
            tail.next = new Node(i); 
            tail = tail.next; 
        }     
        tail.next = head;
    }
    
    /**
     * Find the leaders
     * 
     * Add comments!!!
     */
    public void findLeader() {
        Node pointerOne = head, pointerTwo = head;
        while (pointerOne.next != pointerOne) {
            int count = 1; 
            while(count != m) { 
                pointerTwo = pointerOne; 
                pointerOne = pointerOne.next; 
                count++; 
            }
            System.out.println(pointerOne.item);
            pointerTwo.next = pointerOne.next; 
            pointerOne = pointerTwo.next;
        }
        System.out.println("leader: " + pointerOne.item);
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // n: total number of people
        int m = Integer.parseInt(args[1]);// m-th person is eliminated at each round
        
        // YOUR SOLUTION GOES HERE (Note: if you use a suitable data structure,
        // you can write a solution in under 10 lines of code.)
        Leader leaderList = new Leader(n, m);
        leaderList.findLeader();
    }    
    
}
