package CodeBrainstorming.DP;

/**
 * @Author zlx
 * @Date 2024/6/17 22:17
 */
public class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] +=  dp[j - coins[i]] ;
            }
        }
        return dp[amount];
    }
}
