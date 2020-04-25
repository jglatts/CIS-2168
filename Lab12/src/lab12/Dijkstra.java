package lab12;

import java.util.*;

public class Dijkstra {
    
    public static PriorityQueue<Integer> queue = new PriorityQueue<>();
    public static Set<Integer> settled = new HashSet<>();
    public static int[] dist;
        
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        dist = new int[adj.length];
        queue.add(s);

        for (int i = 0; i < cost.length; ++i) dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;
        
        while (settled.size() != adj.length-1) {
            if (!queue.isEmpty()){
                settled.add(queue.peek());
                checkNeighbors(adj, cost, queue.poll());    
            }
            else return -1;
        }
        return dist[t];
    }

    private static void checkNeighbors(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int v) {
        for (int i = 0; i < adj[v].size(); i++) { 
            int x = adj[v].get(i); 
            if (!settled.contains(x)) { 
                int edgeDist = cost[v].get(i); 
                int newDist = dist[v] + edgeDist; 
                if (newDist < dist[x]) 
                    dist[x] = newDist; 
                queue.add(x); 
            } 
        }       
    }
    
    public static void main(String[] args) {
        In in = new In("G4-1.txt");
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
