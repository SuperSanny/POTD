//GFG: https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
import java.util.*;
public class LongestCommonSubsequence {
    static int lcs(int x, int y, String s1, String s2) {
        int[][] dp = new int[x+1][y+1];
        for(int i = 0; i<= x; i++) {
            for(int j = 0; j<= y; j++){
                if(i==0 || j ==0) dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[x][y];
    }
    public static void main(String[] args) {
        int A = 6, B = 6;
        String str1 = "ABCDGH", str2 = "AEDFHR";
        System.out.println(lcs(A, B, str1, str2));
    }
}
