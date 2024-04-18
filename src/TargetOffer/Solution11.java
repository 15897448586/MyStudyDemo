package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/17 22:56
 */
public class Solution11 {
    public int integerBreak(int n) {
        // 1.贪心 拆出尽可能的多的3
//        if (n <= 3) return n - 1;
//        if (n == 4) return 4;
//        int res = 1;
//        while (n >= 4){
//            res *= 3;
//            n -= 3;
//        }
//        return res * n;

        // 2. dp
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i ; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
