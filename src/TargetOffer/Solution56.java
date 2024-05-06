package TargetOffer;

import java.util.Arrays;

/**
 * @Author zlx
 * @Date 2024/5/6 16:19
 */
public class Solution56 {
    public double[] statisticsProbability(int num) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0/ 6.0);
        for (int i = 2; i <= num; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }
}
