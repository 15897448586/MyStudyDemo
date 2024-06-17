package CodeBrainstorming.DP;

import java.util.Arrays;

/**
 * @Author zlx
 * @Date 2024/6/17 17:27
 */
public class Solution1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0, max = 150010;
        for (int stone : stones) {
            sum += stone;
        }
        // 容量为一版的时候，放下的石头的最大重量
        int target = sum >> 1;
        //初始化dp数组
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            //采用倒序
            for (int j = target; j >= stones[i]; j--) {
                //两种情况，要么放，要么不放
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}
