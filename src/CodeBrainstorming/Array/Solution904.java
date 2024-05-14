package CodeBrainstorming.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author zlx
 * @Date 2024/5/14 23:16
 */
public class Solution904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map =  new HashMap<>();
        int n = fruits.length;
        int j = -1, count = 0;
        for (int i = 0; i < n; i++) {
            int fruit = fruits[i];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            if (map.size() <= 2) {
                count = Math.max(count, i - j);
                continue;
            }
            while (map.size() > 2) {
                int t = map.get(fruits[++i]);
                if (t <= 1) map.remove(t);
                else map.put(fruits[i], t - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new Solution904().totalFruit(new int[] {0,1,2,2});
    }
}
