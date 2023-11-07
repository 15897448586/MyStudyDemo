package leetcode;

import java.util.HashSet;
import java.util.TreeSet;

class Solution01 {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int[] map = new int[set.size()];
        int j = 0;
        for (Integer num : set) {
            map[j++] = num;
        }
        int i = 0, n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && map[i -1] + 1 == map[i]) {
                i++;
            }
            max = Math.max(max, i - low);
        }
        return max;
    }
}