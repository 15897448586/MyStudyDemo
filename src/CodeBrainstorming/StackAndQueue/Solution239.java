package CodeBrainstorming.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author zlx
 * @Date 2024/5/30 14:55
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k){
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        // 将前k个保存进去
        for(int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = nums[dq.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            while (!dq.isEmpty() && i - k >= dq.peekFirst()) {
                dq.pollFirst();
            }
            ans[i - k + 1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}
