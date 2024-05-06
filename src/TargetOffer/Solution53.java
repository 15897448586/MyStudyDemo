package TargetOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zlx
 * @Date 2024/5/2 15:31
 */
public class Solution53 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            if (map.containsKey(b)) return new int[]{i, map.get(b)};
            else map.put(a, i);
        }
        return new int[]{-1, -1};
    }
}
