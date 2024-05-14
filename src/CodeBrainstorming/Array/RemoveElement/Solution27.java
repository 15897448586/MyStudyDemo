package CodeBrainstorming.Array.RemoveElement;

/**
 * @Author zlx
 * @Date 2024/5/14 17:19
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = 0;
        for (; r < nums.length; r++) {
            if (nums[r] == val) continue;
            nums[l++] = nums[r];
        }
        return l;
    }
}
