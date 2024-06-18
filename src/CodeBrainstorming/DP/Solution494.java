package CodeBrainstorming.DP;

/**
 * @Author zlx
 * @Date 2024/6/17 20:34
 */
public class Solution494 {
    // 假设正数为x，负数为sum - x, x - (sum - x) = target
    // x = (target + sum) / 2;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > Math.abs(sum)) return 0;
        if ((target + sum) % 2 == 1) return 0;
        int bagSize = (target + sum) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
