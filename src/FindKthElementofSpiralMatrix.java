import java.util.*;

//GFG: https://practice.geeksforgeeks.org/problems/find-nth-element-of-spiral-matrix/1
public class FindKthElementofSpiralMatrix {
    static int findK(int[][] A, int n, int m, int k){
        List<Integer> ans = new ArrayList<>();
        int row = n;
        int col = m;
        int top = 0, left = 0, right = col-1, bottom = row-1;
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                ans.add(A[top][i]);
            }
            top++;
            for(int i = top; i <= bottom; i++){
                ans.add(A[i][right]);
            }
            right--;
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    ans.add(A[bottom][i]);
                }
                bottom--;
            }
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    ans.add(A[i][left]);
                }
                left++;
            }

        }
        System.out.println(ans);
        return ans.get(k-1);
    }
    public static void main(String[] args) {
        int n = 4, m = 4, k = 10;
        int[][] mat = {{1, 2, 3, 4},{5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int ans = findK(mat, n, m, k);
        System.out.println(ans);

    }
}
