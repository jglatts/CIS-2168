package lab12;

import java.util.*;

public class Dijkstra {
    
    public static PriorityQueue<Integer> queue = new PriorityQueue<>();
    public static Set<Integer> marked = new HashSet<>();
    public static int[] dist;
        
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        dist = new int[adj.length];
        queue.add(s);  // add source vertex to queue
        
        // set all distanaces to infinity  
        for (int i = 0; i < cost.length; ++i) 
            dist[i] = Integer.MAX_VALUE; 
        dist[s] = 0; // distance to source is 0
        
        // loop until we've visited all neighboring vertices
        while (!queue.isEmpty()) {
                int v = queue.poll();
                marked.add(v);
                checkNeighbors(adj, cost, v);    
        }
        return dist[t];
    }

    private static void checkNeighbors(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int v) {
        // loop through adjacent vertices
        for (int i = 0; i < adj[v].size(); i++) { 
            int x = adj[v].get(i); 
            if (!marked.contains(x)) { 
                int edgeDist = cost[v].get(i);    // get the current cost from node v to to adjacent node  
                int newDist = dist[v] + edgeDist; // calculate new cost
                if (newDist < dist[x]) dist[x] = newDist; 
                queue.add(x); 
            } 
        }       
    }
    
    public static void main(String[] args) {
        In in = new In("G4-2.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj  = new ArrayList[n];
        ArrayList<Integer>[] cost = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = in.readInt();
            y = in.readInt();
            w = in.readInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = in.readInt() - 1;
        int y = in.readInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}
