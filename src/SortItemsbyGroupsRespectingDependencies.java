//LeetCode: https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/
import java.util.*;
public class SortItemsbyGroupsRespectingDependencies {
    public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;
        for(int i = 0; i < n; i++) {
            if(group[i] == -1){
                group[i] = groupId;
                groupId++;
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; ++i) {
            map.put(i, new ArrayList<>());
        }
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        int[] groupIndegree = new int[groupId];
        for (int i = 0; i < groupId; ++i) {
            groupGraph.put(i, new ArrayList<>());
        }
        for (int curr = 0; curr < n; curr++) {
            for (int prev : beforeItems.get(curr)) {
                map.get(prev).add(curr);
                itemIndegree[curr]++;
                if (group[curr] != group[prev]) {
                    groupGraph.get(group[prev]).add(group[curr]);
                    groupIndegree[group[curr]]++;
                }
            }
        }
        List<Integer> itemOrder = topologicalSort(map, itemIndegree);
        List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree);
        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            return new int[0];
        }
        Map<Integer, List<Integer>> orderedGroups = new HashMap<>();
        for (Integer item : itemOrder) {
            orderedGroups.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }
        List<Integer> answerList = new ArrayList<>();
        for (int groupIndex : groupOrder) {
            answerList.addAll(orderedGroups.getOrDefault(groupIndex, new ArrayList<>()));
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
    private static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] indegree) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer key : graph.keySet()) {
            if (indegree[key] == 0) {
                stack.add(key);
            }
        }
        while (!stack.isEmpty()) {
            Integer curr = stack.pop();
            visited.add(curr);
            for (Integer prev : graph.get(curr)) {
                indegree[prev]--;
                if (indegree[prev] == 0) {
                    stack.add(prev);
                }
            }
        }
        return visited.size() == graph.size() ? visited : new ArrayList<>();
    }

    public static void main(String[] args) {
       int  n = 8, m = 2;
       int[] group = {-1,-1,1,0,0,1,0,-1};
//       int[][] beforeItems = {{},{6},{5},{6},{3,6},{},{},{}};
       List<List<Integer>> beforeItems = new ArrayList<>();
        beforeItems.add(new ArrayList<>());
        beforeItems.add(List.of(6));
        beforeItems.add(List.of(5));
        beforeItems.add(List.of(6));
        beforeItems.add(Arrays.asList(3,6));
        beforeItems.add(new ArrayList<>());
        beforeItems.add(new ArrayList<>());
        beforeItems.add(new ArrayList<>());
        System.out.println(Arrays.toString(sortItems(n, m, group, beforeItems)));
    }
}
