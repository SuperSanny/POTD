//LeetCode: https://leetcode.com/problems/coin-change-ii/description/
public class CoinChangeII {
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = n-1; i>=0; i--) {
            for(int j = coins[i]; j<= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(change(amount, coins));
    }
}
