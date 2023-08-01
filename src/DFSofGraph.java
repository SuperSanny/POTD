//GFG: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
import java.util.*;
public class DFSofGraph {
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] visited = new int[V];
        dfs(0, ans, visited, adj);
        return ans;
    }
    public static void dfs(int node, ArrayList<Integer> ans, int[] visited, ArrayList<ArrayList<Integer>> adj) {
        ans.add(node);
        visited[node] = 1;
        for(int num: adj.get(node)){
            if(visited[num] == 0) dfs(num, ans, visited, adj);
        }
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

        ArrayList<Integer> result = dfsOfGraph(V, adj);
        for(int vertex : result){
            System.out.println(vertex + " ");
        }
    }
}
