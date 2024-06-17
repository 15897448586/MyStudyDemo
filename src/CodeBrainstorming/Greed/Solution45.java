package CodeBrainstorming.Greed;

/**
 * @Author zlx
 * @Date 2024/6/13 17:56
 */
public class Solution45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        int count = 0, curDistance = 0, maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,0,1,4};
        System.out.println(new Solution45().jump(nums));
    }
}
