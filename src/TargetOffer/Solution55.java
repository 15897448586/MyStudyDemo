package TargetOffer;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author zlx
 * @Date 2024/5/6 16:00
 */
public class Solution55 {

    public int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        Deque<Integer> deque =  new ArrayDeque<>();
        // 维护一个单调递减队列
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans =  new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            // 如果当前的大于前面所有的，那么会被全部弹出，
            // 仍然维护一个递减队列
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 判断当前最大的数据是都越界了，越界则找到不越界的数据
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        Deque<Integer> deque = new ArrayDeque<>();
//        for (int i = 0; i < k; ++i) {
//            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
//                deque.pollLast();
//            }
//            deque.offerLast(i);
//        }
//
//        int[] ans = new int[n - k + 1];
//        ans[0] = nums[deque.peekFirst()];
//        for (int i = k; i < n; ++i) {
//            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
//                deque.pollLast();
//            }
//            deque.offerLast(i);
//            while (deque.peekFirst() <= i - k) {
//                deque.pollFirst();
//            }
//            ans[i - k + 1] = nums[deque.peekFirst()];
//        }
//        return ans;
//    }

}
