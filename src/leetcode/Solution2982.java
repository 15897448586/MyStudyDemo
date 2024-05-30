package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zlx
 * @Date 2024/5/30 9:49
 */
public class Solution2982 {
    public int maximumLength(String s) {
        int res = -1;
        Map<Character, int[]> map = new HashMap<Character, int[]>();
        char[] chars = s.toCharArray();
        int i = 0, n = s.length();
        while (i < n) {
            int j = i;
            i++;
            while (i < n && chars[i] == chars[i - 1]) {
                i++;
            }
            if (!map.containsKey(chars[j])) {
                map.put(chars[j], new int[4]);
            }
            int[] ints = map.get(chars[j]);
            if (i - j > ints[0]) {
                ints[1] = ints[0];
                ints[3] = ints[2];
                ints[0] = i - j;
                ints[2] = 1;
            } else if (i - j == ints[0]) {
                ints[2]++;
            } else {
                if (i - j > ints[1]) {
                    ints[1] = i - j;
                    ints[3] = 1;
                } else if (i - j == ints[1]) {
                    ints[3]++;
                }
            }
        }
        for (Character character : map.keySet()) {
            int[] ints = map.get(character);
            // 先判断第一个
            // 1.当前数量直接大于三个
            if (ints[2] >= 3) {
                res = Math.max(ints[0], res);
                continue;
            } else if (ints[2] == 2 && ints[0] >= 2) {
                res = Math.max(ints[0] - 1, res);
            } else if (ints[2] == 1 && ints[0] >= 3) {
                res = Math.max(ints[0] - 2, res);
            }
            if (ints[3] > 0) {
                res = Math.max(ints[1], res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution2982().maximumLength("ababababbabababababbababsddddddddd");
    }
}
