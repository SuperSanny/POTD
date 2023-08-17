//LeetCode: https://leetcode.com/problems/01-matrix/
import java.util.*;
public class Matrix01 {
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = mat[i][j];
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(dp[i][j] == 0) continue;
                int minNeighbor = m*n;
                if (i > 0) minNeighbor = Math.min(minNeighbor, dp[i - 1][j]);
                if (j > 0) minNeighbor = Math.min(minNeighbor, dp[i][j - 1]);
                dp[i][j] = minNeighbor + 1;
            }
        }
        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (dp[row][col] == 0) continue;
                int minNeighbor = m * n;
                if (row < m - 1) minNeighbor = Math.min(minNeighbor, dp[row + 1][col]);
                if (col < n - 1) minNeighbor = Math.min(minNeighbor, dp[row][col + 1]);
                dp[row][col] = Math.min(dp[row][col], minNeighbor + 1);
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] result = updateMatrix(mat);
        System.out.println(Arrays.toString(result));
    }
}
