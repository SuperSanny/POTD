//LeetCode: https://leetcode.com/problems/maximal-network-rank/
import java.util.*;
public class MaximalNetworkRank {
    public static int maximalNetworkRank(int n, int[][] roads) {
        int maxRank = 0;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int[] road: roads){
            adj.computeIfAbsent(road[0], k-> new HashSet<>()).add(road[1]);
            adj.computeIfAbsent(road[1], k-> new HashSet<>()).add(road[0]);
        }
        for (int i = 0; i <n; i++) {
            for (int j = i+1; j <n; j++) {
                int currRank = adj.getOrDefault(i, Collections.emptySet()).size() +
                        adj.getOrDefault(j, Collections.emptySet()).size();
                if(adj.getOrDefault(i, Collections.emptySet()).contains(j)) --currRank;
                maxRank = Math.max(maxRank, currRank);
            }
        }
        return maxRank;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{0,1}, {0,3}, {1,2}, {1,3}};
        System.out.println(maximalNetworkRank(n, roads));
    }
}
