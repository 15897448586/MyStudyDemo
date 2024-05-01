package leetcode;

import java.util.PriorityQueue;

/**
 * @Author zlx
 * @Date 2024/5/1 17:15
 */
public class Solution2 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int left = candidates - 1, right = n - candidates;
        if (left + 1 < right) {
            for (int i = 0; i <= left; i++) {
                pq.offer(new int[]{costs[i], i});
            }
            for (int i = right; i < n; i++) {
                pq.offer(new int[]{costs[i], i});
            }
        } else {
            for (int i = 0; i < n; i++) {
                pq.offer(new int[]{costs[i], i});
            }
        }
        long ans = 0;
        for (int i = 0; i < k; ++i) {
            int[] arr = pq.poll();
            int cost = arr[0], id = arr[1];
            ans += cost;
            if (left + 1 < right) {
                if (id <= left) {
                    ++left;
                    pq.offer(new int[]{costs[left], left});
                } else {
                    --right;
                    pq.offer(new int[]{costs[right], right});
                }
            }
        }
        return ans;
    }

}
