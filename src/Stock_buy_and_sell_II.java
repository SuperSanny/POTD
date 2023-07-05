//GFG: https://practice.geeksforgeeks.org/problems/stock-buy-and-sell2615/1
public class Stock_buy_and_sell_II {
    public static int stockBuyAndSell(int n, int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < n; i++) {
            int minPrice = prices[i-1];
            int profit = Math.max(0, prices[i] - minPrice);
            maxProfit += profit;
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 3, 5, 7, 9};
        int ans = stockBuyAndSell(n, arr);
        System.out.println(ans);
    }
}
