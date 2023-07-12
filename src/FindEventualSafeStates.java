import java.util.*;
public class FindEventualSafeStates {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<Integer>();
        int[] visited = new int[graph.length];
        for(int i = 0; i < graph.length; i++)
            if(isSafe(i, graph, visited)) result.add(i);

        return result;
    }
    static boolean isSafe(int index, int[][] graph, int[] visited) {
        if(visited[index] == 2) return true;
        if(visited[index] == 1) return false;
        visited[index] = 1;
        int[] neighbors = graph[index];
        for(int i = 0; i < neighbors.length; i++)
            if(!isSafe(neighbors[i], graph, visited)) return false;

        visited[index] = 2;
        return true;
    }
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3},{5}, {0}, {5}, {}, {}};
        List<Integer> nodes = new ArrayList<>();
        System.out.println(eventualSafeNodes(graph));
    }
}
