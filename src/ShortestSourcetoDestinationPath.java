//GFG: https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1
import java.util.*;
public class ShortestSourcetoDestinationPath {

    private static final int[] dx = {-1,1,0,0};
    private static final int[] dy = {0, 0, -1, 1};
    static int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if(A[0][0] == 0) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int count = 0;
        A[0][0] = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz > 0) {
                int[] p = queue.poll();
                int i = p[0];
                int j = p[1];
                if (i == X && j == Y) return count;
                for (int d = 0; d < 4; d++) {
                    int x = i + dx[d];
                    int y = j + dy[d];
                    if (isValid(x, y, N, M) && A[x][y] == 1) {
                        A[x][y] = 0;
                        queue.offer(new int[]{x, y});
                    }
                }
                sz--;
            }
            count++;
        }
        return -1;
    }
    private static boolean isValid(int x, int y, int N, int M){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 1}, {0,0,0,1},{0,0,0,1}};
        int x = 0, y = 3;
        System.out.println(shortestDistance(arr.length, arr[0].length, arr, x, y));
    }
}
