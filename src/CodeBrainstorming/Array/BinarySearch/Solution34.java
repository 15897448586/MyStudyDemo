package CodeBrainstorming.Array.BinarySearch;

/**
 * @Author zlx
 * @Date 2024/5/14 16:43
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = binarySearch(nums, target);
        if (l >= n ||(l >= 0 && nums[l] != target)) return new int[]{-1, -1};
        int r = binarySearch(nums, target + 1);
        return new int[]{l, r - 1};
    }

    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}
