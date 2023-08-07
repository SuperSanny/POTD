//GFG: https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1
import java.util.*;
public class SolvetheSudoku {
    static final int N = 9;
    static boolean SolveSudoku(int[][] grid) {
        return Solve(grid, 0, 0);
    }
    private static boolean Solve(int[][] grid, int row, int col){
        if(row == N-1 && col == N) return true;
        if(col == N) {
            row++;
            col = 0;
        }
        if(grid[row][col] != 0) return Solve(grid, row, col+1);
        for(int i = 1; i <= N; i++) {
            if(isSafe(grid, row, col, i)){
                grid[row][col] = i;
                if(Solve(grid, row, col+1)) return true;
            }
            grid[row][col] = 0;
        }
        return false;
    }
    public static boolean isSafe(int[][] grid, int row, int col, int num){
        for(int i = 0; i < N; i++){
            if(grid[row][i] == num) return false;
        }
        for (int i = 0; i < N; i++) {
            if(grid[i][col] == num) return false;
        }
        int sr = row - row % 3, sc = col - col % 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(grid[i + sr][j + sc] == num) return false;
            }
        }
        return true;
    }
    static void printGrid (int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] grid ={
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        System.out.println(SolveSudoku(grid));
        if(Solve(grid, 0, 0)) printGrid(grid);
    }
}
