package CodeBrainstorming.DP;

import java.util.Arrays;

/**
 * @Author zlx
 * @Date 2024/6/18 13:51
 */
public class Solution279 {
    private int max = 10000;
    public int numSquares(int n) {
        // dp[j]为数量j下的最小数量
        int[] dp = new int[n + 1];
        Arrays.fill(dp, max + 1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= 100; i++) {
            int t = i * i;
            for (int j = t; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - t] + 1);
            }
        }
        return dp[n] == max + 1 ? -1 : dp[n];
    }

    public static void main(String[] args) {
        new Solution279().numSquares(12);
    }
}
