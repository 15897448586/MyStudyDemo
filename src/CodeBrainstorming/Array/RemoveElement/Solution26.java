package CodeBrainstorming.Array.RemoveElement;

/**
 * @Author zlx
 * @Date 2024/5/14 17:30
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int l = 1, r = 1;
        for (; r < nums.length; r++) {
            if (nums[r] == nums[l - 1]) continue;
            nums[l++] = nums[r];
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Solution26().removeDuplicates(nums));
    }
}
