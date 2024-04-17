package TargetOffer;

import java.util.Random;

/**
 * 使用二分查找，首先假定第一个是最小值
 * 如果存在重复值，因此不断缩小右边界，使nums[r] < nums[0]
 * 接下来二分与第一个作比较，如果nums[mid] >= nums[0]
 * 那么证明 当前是递增的，分界点一定在右边，不断地增加
 * 两种情况 一直找到r，这个r == n - 1 说明第一个是最小值
 * 否则，r + 1是最小值，通过最大找最小。
 * @Author zlx
 * @Date 2024/4/16 14:57
 */
public class Solution8 {

    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <  r && nums[0] == nums[r]) r--;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return r + 1 < n ? nums[r + 1] : nums[0];
    }


    public static void main(String[] args) {
        Solution8 s = new Solution8();
//        int nums[] = {0, 1, 4, 4, 5, 6, 7};
        int nums[] = {3, 1 , 2};
        int n = nums.length;
        Random r = new Random();
        int offset = r.nextInt() % n;
        offset = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[(i + offset) % n] = nums[i];
        }
        int min = s.findMin(arr);
        System.out.println(min);
    }
}
