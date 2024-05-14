package CodeBrainstorming.Array.RemoveElement;

/**
 * @Author zlx
 * @Date 2024/5/14 17:46
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i == j) continue;
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) nums[j++] = 0;
    }
}
