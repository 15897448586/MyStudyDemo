package CodeBrainstorming.DP;

/**
 * @Author zlx
 * @Date 2024/6/18 20:35
 */
public class Solution309 {
    /**
     * 定义以下四个状态【0】 买入， 【1】 已经卖出， 【2】今天卖出  【3】 冻结期
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            //
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] , dp[i - 1][3]) - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[n - 1][1], Math.max(dp[n - 1][2], dp[n - 1][3]));
    }
}
