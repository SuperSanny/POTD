//LeetCode: https://leetcode.com/problems/maximum-length-of-pair-chain/
import java.util.*;
public class MaximumLengthofPairChain {
    public static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = n-1; i>=0; i--){
            for(int j = i+1; j<n; j++){
                if(pairs[i][1] < pairs[j][0]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] pairs = {{1,2},{7,8}, {4,5}};
        System.out.println(findLongestChain(pairs));
    }
}
