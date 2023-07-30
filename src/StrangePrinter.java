//LeetCode: https://leetcode.com/problems/strange-printer/
public class StrangePrinter {
    public static int strangePrinter(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i = 1; i<= n; i++) {
            for(int left = 0; left <= n - i; left++) {
                int right = left + i  -1;
                int j = -1;
                dp[left][right] = n;
                for(int k = left; k < right; k++) {
                    if(s.charAt(k) != s.charAt(right) && j == -1) j = k;
                    if(j != -1) dp[left][right] = Math.min(dp[left][right], 1+dp[j][k] + dp[k+1][right]);
                }
                if(j == -1) dp[left][right] = 0;
            }
        }
        return dp[0][n-1]+1;
    }
    public static void main(String[] args) {
        String s = "aaabbb";
        System.out.println(strangePrinter(s));
    }
}
