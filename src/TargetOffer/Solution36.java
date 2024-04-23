package TargetOffer;

import java.util.PriorityQueue;

/**
 * @Author zlx
 * @Date 2024/4/23 22:29
 */
public class Solution36 {
    int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                swap(nums, i, j);
            }
        }
        if (k <= j) return quickselect(nums, l, j, k);
        else return quickselect(nums, j + 1, r, k);
    }

    public int findKthLargest(int[] _nums, int k) {
//        int n = _nums.length;
//        return quickselect(_nums, 0, n - 1, n - k);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : _nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // 2. 优先队列


}
