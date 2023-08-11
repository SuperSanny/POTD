//GFG: https://practice.geeksforgeeks.org/problems/coin-change2448/1
public class CoinChange {
    public static long count(int coins[], int N, int sum) {
        long[] dp = new long[sum+1];
        dp[0] = 1;
        for(int i = N-1; i >= 0; i--){
            for(int j = coins[i]; j <= sum; j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[sum];
    }
    public static void main(String[] args) {
        int N = 3, sum = 4;
        int[] coins = {1,2,3};
        System.out.println(count(coins, N, sum));
    }
}
