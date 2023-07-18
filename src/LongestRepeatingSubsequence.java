//GFG: https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
import java.util.*;
public class LongestRepeatingSubsequence {
    public static int LongestRepeatingSubsequence(String str)
    {
        int n = str.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 0);
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(str.charAt(i - 1) == str.charAt(j - 1) && i != j){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int longest = dp[n][n];
        return longest;
    }
    public static void main(String[] args) {
        String str = "axxxy";
        System.out.println(LongestRepeatingSubsequence(str));
    }
}
