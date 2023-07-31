//GFG: https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
import java.util.*;
public class BFSofgraph {
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<Integer>();
        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int currVertex = queue.poll();
            bfs.add(currVertex);
            for(int neighbor : adj.get(currVertex)) {
                if(!visited[neighbor]){
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        ArrayList<Integer> result = bfsOfGraph(V, adj);
        for(int vertex : result){
            System.out.println(vertex + " ");
        }
    }
}
