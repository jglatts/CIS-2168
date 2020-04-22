package lab12;

import java.util.ArrayList;
import java.util.Arrays;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        // YOUR CODE HERE
        boolean[] marked = new boolean[adj.length];
        dfs(adj, x, marked);
        return marked[y] ? 1 : 0;  // <- change this line to return the correct result
    }

    // Hint: review depth-first search (dfs). It may be 'cleaner' to write a
    // separate helper method (dfs) and call it from your code in reach().
    // Alternatively, you can keep all your logic in reach(), if you wish.
     private static void dfs(ArrayList<Integer>[] adj, int v, boolean[] marked) { 
         marked[v] = true;
         for (int dest : adj[v]) {
            if (!marked[dest])
                dfs(adj, dest, marked);
         }
     }


    public static void main(String[] args) {
        In in = new In("G1-3.txt");
        int n = in.readInt();  // number of vertices
        int m = in.readInt();  // number of edges

        // for each vertex, allocate space for its adjacency list
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // read the next m lines of input and build an
        // adjacency list representation of the graph
        for (int i = 0; i < m; i++) {
            int x, y;
            x = in.readInt();
            y = in.readInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(Arrays.toString(adj) + "\n");

        // read the last line of the input file.
        // x = the start vertex; y = the end vertex
        int x = in.readInt() - 1;
        int y = in.readInt() - 1;
        // is y reachable from x
        System.out.println(reach(adj, x, y));
    }
}
