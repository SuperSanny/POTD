//GFG: https://practice.geeksforgeeks.org/problems/surround-the-1s2505/1
import java.util.*;
public class Surroundthe1s {
    public static int  Count(int[][] matrix) {
        int count = 0;
        int rows = matrix.length, cols = matrix[0].length;
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j] == 1 && isSurround(matrix, i, j)) count++;
            }
        }
        return count;
    }
    public static boolean isSurround(int[][] matrix, int row, int col) {
        int zero = 0;
        for(int i = -1; i<= 1; i++) {
            for(int j = -1; j<= 1; j++) {
                int x = row + i, y = col + j;
                if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) continue;
                if(matrix[x][y] == 0) zero++;
            }
        }
        return (zero > 0 && zero % 2 == 0);
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0}, {1, 1, 0}, {0, 1, 0}};
        System.out.println(Count(matrix));
    }
}
