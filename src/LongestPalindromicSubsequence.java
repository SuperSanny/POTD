//GFG: https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1
import java.util.*;
public class LongestPalindromicSubsequence {
    public static int longestPalinSubseq(String S) {
        int[][] dp = new int[S.length()][S.length()];
        for(int i = S.length() - 1; i >= 0; i--){
            dp[i][i] = 1;
            for(int j = i+1; j < S.length(); j++){
                if(S.charAt(i) == S.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][S.length()-1];
    }
    public static void main(String[] args) {
        String S = "abcd";
        System.out.println(longestPalinSubseq(S));
    }
}
