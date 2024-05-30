package CodeBrainstorming.StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author zlx
 * @Date 2024/5/30 15:14
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 小根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (x, y) -> x[1] - y[1]);
        for (Integer key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
            while (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[k];
        while (!pq.isEmpty()) {
            ans[--k] = pq.poll()[0];
        }
        return ans;
    }
}
