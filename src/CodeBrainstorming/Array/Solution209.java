package CodeBrainstorming.Array;

/**
 * @Author zlx
 * @Date 2024/5/14 20:51
 */
public class Solution209 {
    public int minSubArrayLen01(int target, int[] nums) {
        int n = nums.length;
        if (nums[0] >= target) return 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] >= target) return 1;
            nums[i] += nums[i - 1];
        }
        // 枚举长度
        for (int i = 2; i < n; i++) {
            if (nums[i - 1] >= target) return i;
            for (int j = i; j < n; j++) {
                if (nums[j] - nums[j - i] >= target) return i;
            }
        }

        return nums[n - 1] >= target ? n : 0;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = -1, j = 0, min = n + 1, sum = 0;
        for (; j < n; j++) {
            sum += nums[j];
            while (sum >= target) {
                min = Math.min(j - i, min);
                sum -= nums[++i];
            }
        }
        return min == n + 1 ? 0 : min;
    }
}
