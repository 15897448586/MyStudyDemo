package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/5/6 17:23
 */
public class Solution59 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
}
