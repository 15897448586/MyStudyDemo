package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zlx
 * @Date 2024/5/29 18:01
 */
public class Solution2981 {
    public int maximumLength(String s) {
        int res = -1;
        Map<Character, int[]> map =  new HashMap<Character, int[]>();
        char[] chars = s.toCharArray();
        int i = 0, n = s.length();
        while (i < n) {
            int j = i;
            i++;
            while (i < n && chars[i] == chars[i - 1]) {
                i++;
            }
            if (!map.containsKey(chars[j])) {
                map.put(chars[j], new int[51]);
            }
            map.get(chars[j])[i - j]++;
        }
        for (Character character : map.keySet()) {
            int[] ints = map.get(character);
            boolean first = false;
            for (int j = ints.length - 1; j >= 0; j--) {
                if (ints[j] != 0) {
                    if (first) {
                        res = Math.max(j ,res);
                        break;
                    }
                    // 1.当前数量直接大于三个
                    if (ints[j] >= 3) {
                        res = Math.max(j,  res);
                        break;
                    }else if (ints[j] == 2 && j >= 2) {
                        res = Math.max(j - 1, res);
                    }else if (ints[j] == 1 && j >= 3) {
                        res = Math.max(j - 2, res);
                    }
                    first = true;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        new Solution2981().maximumLength("aac");
    }
}
