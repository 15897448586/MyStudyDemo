package CodeBrainstorming.DP;

import java.util.Arrays;

/**
 * @Author zlx
 * @Date 2024/6/17 17:11
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) != 0) return false;
        //目标值
        int target = sum >> 1;
        // i个数组，j的背包中，是否有权重等于target的
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for(int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
                if (dp[j] == target) return true;
            }
        }
        return false;
    }
}
