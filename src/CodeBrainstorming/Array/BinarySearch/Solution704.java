package CodeBrainstorming.Array.BinarySearch;

/**
 * @Author zlx
 * @Date 2024/5/13 17:58
 */
public class Solution704 {
    public int search(int[] nums, int target) {
        return binarySearch01(nums,target);
    }

    public static int binarySearch01(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearch02(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return -1;
    }
}
