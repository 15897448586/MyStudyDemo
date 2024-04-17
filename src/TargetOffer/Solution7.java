package TargetOffer;

/** 斐波拉契数列 --打表
 * @Author zlx
 * @Date 2024/4/16 14:45
 */
public class Solution7 {
    private static int[] dp = new int[31];
    static {
        dp[1] = 1;
        for (int i = 2; i < 31; i++) {
            dp[i] = dp[i - 1] + dp[i - 1];
        }
    }
    public int fib(int n) {
        return dp[n];
    }

}
