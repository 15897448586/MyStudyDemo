package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/30 16:02
 */
public class Solution47 {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        return reversePairs(nums, 0, nums.length - 1);
    }

    public int reversePairs(int[] nums, int left, int right) {
        if (left == right) return 0;
        int mid = left + (right - left) / 2;
        // 递归，统计左右数组内部的逆序对
        int n1 = reversePairs(nums, left, mid);
        int n2 = reversePairs(nums, mid + 1, right);
        int ret = n1 + n2;
        int i = left, j = mid + 1;
        // 统计左数组 和右数组一起形成的逆序对
        while (i <= mid) {
            while (j < right && (long) nums[i] > 2L * nums[j]) j++;
            ret += j - mid - 1;
            i++;
        }
        int[] sorted = new int[right - left + 1];
        int p1 = left, p2 = mid + 1;
        int p = 0;
        // 归并排序
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                sorted[p++] = nums[p2++];
            } else if (p2 > right) {
                sorted[p++] = nums[p1++];
            } else{
                if (nums[p1] < nums[p2]) {
                    sorted[p++] = nums[p1++];
                }else{
                    sorted[p++] = nums[p2++];
                }
            }
        }
        // 将排好序的数组赋值给原数组
        for(int k = 0; k < sorted.length; k++) {
            nums[left + k] = sorted[k];
        }
        return ret;
    }
}
