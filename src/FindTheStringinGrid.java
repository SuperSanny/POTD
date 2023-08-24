//GFG: https://practice.geeksforgeeks.org/problems/find-the-string-in-grid0111/1
import java.util.*;
public class FindTheStringinGrid {
    public static int[][] searchWord(char[][] grid, String word) {
        int n = grid.length, m = grid[0].length;
        List<int[]> list = new ArrayList<int[]>();
        int[] x = {-1,-1,-1,0,0,1,1,1};
        int[] y = {-1,0,1,-1,1,-1,0,1};
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == word.charAt(0)){
                    for(int dir = 0; dir < 8; dir++){
                        int newRow = i + x[dir];
                        int newColumn = j + y[dir];
                        int k;
                        for(k = 1; k < word.length(); k++){
                            if(newRow < 0 || newRow >= n || newColumn < 0 || newColumn >= m || grid[newRow][newColumn] != word.charAt(k)) break;
                            newRow += x[dir];
                            newColumn += y[dir];
                        }
                        if(k == word.length()){
                            list.add(new int[]{i,j});
                            break;
                        }
                    }
                }
            }
        }
        int[][] result = new int[list.size()][];
        for(int i=0; i<list.size(); i++) result[i] = list.get(i);
        return result;
    }

    public static void main(String[] args) {
        char[][] grid = {{'a','b','a','b'},{'a','b','e','b'},{'e','b','e','b'}};
        String word = "abe";
        int[][] ans = searchWord(grid, word);
        for (int[] sol : ans) {
            System.out.println(Arrays.toString(sol));
        }
    }
}
