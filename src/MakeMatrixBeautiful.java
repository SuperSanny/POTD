//GFG: https://practice.geeksforgeeks.org/problems/make-matrix-beautiful-1587115620/1
import java.util.*;
public class MakeMatrixBeautiful {
    public static int findMinOperation(int N, int[][] matrix) {
        int maxRow = Integer.MIN_VALUE, maxCol = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < N; i++) {
            int row = 0, col = 0;
            for(int j = 0; j < N; j++) {
                row += matrix[i][j];
                col += matrix[j][i];
                sum += matrix[i][j];
            }
            maxRow = Math.max(maxRow, row);
            maxCol = Math.max(maxCol, col);
        }
        int max = Math.max(maxRow, maxCol);
        return (max * N) - sum;
    }
    public static void main(String[] args) {
        int N = 3;
        int[][] matrix = {{1, 2, 3}, {4, 2, 3}, {3, 2, 1}};
        System.out.println(findMinOperation(N, matrix));
    }
}
