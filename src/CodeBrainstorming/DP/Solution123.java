package CodeBrainstorming.DP;

/**
 * @Author zlx
 * @Date 2024/6/18 17:48
 */
public class Solution123 {
    /**
     * 定义以下5种状态,0表示无任何操作，1表示第一次持有股票，2表示第一次卖出股票，3表示第二次持有股票，4表示第二次卖出股票
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
        }
        return dp[n - 1][4];
    }
}
