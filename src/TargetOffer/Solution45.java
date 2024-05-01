package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/30 15:19
 */
public class Solution45 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3,  dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n];
    }
}
