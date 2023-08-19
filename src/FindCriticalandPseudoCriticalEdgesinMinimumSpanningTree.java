//LeetCode: https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/description/
import java.util.*;
public class FindCriticalandPseudoCriticalEdgesinMinimumSpanningTree {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) newEdges[i][j] = edges[i][j];
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, Comparator.comparingInt(edge -> edge[2]));
        UnionFind ufStd = new UnionFind(n);
        int stdWeight = 0;
        for (int[] edge : newEdges) {
            if (ufStd.union(edge[0], edge[1])) stdWeight += edge[2];
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) result.add(new ArrayList<>());
         for (int i = 0; i < m; i++) {
            UnionFind ufIgnore = new UnionFind(n);
            int ignoreWeight = 0;
            for (int j = 0; j < m; j++) {
                if (i != j && ufIgnore.union(newEdges[j][0], newEdges[j][1])) ignoreWeight += newEdges[j][2];
            }
            if (ufIgnore.maxSize < n || ignoreWeight > stdWeight) {
                result.get(0).add(newEdges[i][3]);
            } else {
                UnionFind ufForce = new UnionFind(n);
                ufForce.union(newEdges[i][0], newEdges[i][1]);
                int forceWeight = newEdges[i][2];
                for (int j = 0; j < m; j++) {
                    if (i != j && ufForce.union(newEdges[j][0], newEdges[j][1])) forceWeight += newEdges[j][2];
                }
                if (forceWeight == stdWeight) result.get(1).add(newEdges[i][3]);
            }
        }
        return result;
    }
    class UnionFind {
        int[] parent;
        int[] size;
        int maxSize;
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            maxSize = 1;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    int temp = rootX;
                    rootX = rootY;
                    rootY = temp;
                }
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                maxSize = Math.max(maxSize, size[rootX]);
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
        FindCriticalandPseudoCriticalEdgesinMinimumSpanningTree obj = new FindCriticalandPseudoCriticalEdgesinMinimumSpanningTree();
        System.out.println(obj.findCriticalAndPseudoCriticalEdges(n, edges));
    }
}
