package CodeBrainstorming.Array.BinarySearch;

/**
 * 二分查找的几种实现
 * @Author zlx
 * @Date 2024/5/13 18:09
 */
public class BinarySearchDemo {
    // 二分的本质是二段性而非有序性
    // 1.左右取闭区间
    public int binarySearch01(int[] nums, int target) {
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
