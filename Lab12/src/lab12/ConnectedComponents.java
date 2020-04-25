package lab12;

import java.util.ArrayList;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        // YOUR CODE HERE
        int count = 0;
        boolean[] marked = new boolean[adj.length];
        for (int i = 0; i < adj.length; ++i) {
            if (!marked[i]) {
                findCC(adj, i, marked);
                count++;    
            }
        }
        return count; // <- change this line to return the correct result
    }

    // feel free to add a helper method to make your code cleaner & modular.
     private static void findCC(ArrayList<Integer>[] adj, int v, boolean[] marked) { 
         marked[v] = true;
         for (int dest : adj[v]) {
            if (!marked[dest])
                // recurse on this node and visit all neighbors
                findCC(adj, dest, marked);
         }
     }

    public static void main(String[] args) {
        In in = new In("G2-3.txt");
        //In in = new In("mediumG.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = in.readInt();
            y = in.readInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

