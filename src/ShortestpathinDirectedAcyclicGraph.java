//https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
import java.util.*;
public class ShortestpathinDirectedAcyclicGraph {
    public static int[] shortestPath(int N,int M, int[][] edges) {
        List<int[]>[] graph = new List[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            graph[u].add(new int[]{v, weight});
        }
        int[] indegree = new int[N];
        for(int[] edge : edges) {
            int v = edge[1];
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i< N; i++) {
            if(indegree[i] == 0) queue.add(i);
        }
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if(distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]){
                    distance[v] = distance[u] + weight;
                }
                indegree[v]--;
                if(indegree[v]==0) queue.add(v);
            }
        }
        for (int i = 0; i < N; i++) {
            if(distance[i] == Integer.MAX_VALUE) distance[i] = -1;
        }
        return distance;
	}
    public static void main(String[] args) {
        int N = 4, M = 2;
        int[][] edge = {{0,1,2}, {0,2,1}};
        int[] result = shortestPath(N, M, edge);
        System.out.println(Arrays.toString(result));
    }
}
