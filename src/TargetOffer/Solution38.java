package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/25 15:05
 */
public class Solution38 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        int max = dp[0];
//        for (int i = 1; i < n; i++) {
//            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
//            max = Math.max(max,dp[i]);
//        }
//        return max;
        int max = nums[0];
        int curMax = nums[0];
        for (int i = 1; i < n; i++) {
            curMax =  Math.max(curMax + nums[i], nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution38 s = new Solution38();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        s.maxSubArray(nums);
    }
}
