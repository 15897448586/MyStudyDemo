package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author zlx
 * @Date 2024/6/17 9:56
 */
public class Solution522 {
    public int findLUSlength(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int max = -1;
        Set<String> keys = map.keySet();
        for (String key : keys) {
            if (map.get(key) == 1) {
                boolean ok = true;
                for (String s : keys) {
                    if (!check(s, key)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    max = Math.max(max, key.length());
                }
            }
        }
        return max;
    }

    private boolean check(String s, String key) {
        int i = 0, j = 0;
        while (i < s.length() && j < key.length()) {
            if (s.charAt(i) == key.charAt(j)) {
                j++;
            }
            i++;
        }
        return !s.equals(key) && j == key.length();
    }

    public static void main(String[] args) {
        String[] strs = {"aabbcc", "aabbcc","cb","abc"};
        System.out.println(new Solution522().findLUSlength(strs));
    }
}
