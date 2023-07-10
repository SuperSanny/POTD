import java.util.Arrays;

//GFG: https://practice.geeksforgeeks.org/problems/transpose-of-matrix-1587115621/1
public class TransposeofMatrix {
    public static void transpose(int n,int a[][])
    {
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                swap(a, i, j);
            }
        }
        for (int[] row: a) {
            for (int element: row) {
                System.out.print(element+", ");
            }
            System.out.println();
        }
    }
    static void swap(int[][] mat, int i, int j) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }
    public static void main(String[] args) {
        int N = 4;
        int[][] mat = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
        transpose(N, mat);
    }
}
