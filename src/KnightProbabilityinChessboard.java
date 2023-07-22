//LeetCode: https://leetcode.com/problems/knight-probability-in-chessboard/
import java.util.*;
public class KnightProbabilityinChessboard {
    private static final int[][] DIRECTIONS = {
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}
    };
    private static double calculateProbability(int n, int k, int row, int column, double[][][] dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) return 0.0;
        if (k == 0) return 1.0;
        if (dp[row][column][k] > 0.0) return dp[row][column][k];
        double probability = 0.0;
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];
            probability += 0.125 * calculateProbability(n, k - 1, newRow, newColumn, dp);
        }
        dp[row][column][k] = probability;
        return probability;
    }
    public static double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        return calculateProbability(n, k, row, column, dp);
    }
    public static void main(String[] args) {
        int n = 3, k =2, row = 0, column = 0;
        System.out.println(knightProbability(n, k, row, column));
    }
}
