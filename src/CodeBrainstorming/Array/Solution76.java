package CodeBrainstorming.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zlx
 * @Date 2024/5/15 0:39
 */
public class Solution76 {

    public String minWindow01(String s, String t) {
        int n = s.length(), tot = 0;
        int[] c1 = new int[60], c2 = new int[60];
        for (char x : t.toCharArray()) {
            if (++c1[getIdx(x)] == 1) tot++;
        }
        String ans = "";
        for (int i = 0, j = 0; i < n; i++) {
            int idx1 = getIdx(s.charAt(i));
            if (++c2[idx1] == c1[idx1]) tot--;
            while (j < i) {
                int idx2 = getIdx(s.charAt(j));
                if (c2[idx2] > c1[idx2] && --c2[idx2] >= 0) j++;
                else break;
            }
            if (tot == 0 && (ans.length() == 0 || ans.length() > i - j + 1)) ans = s.substring(j, i + 1);
        }
        return ans;
    }

    int getIdx(char x) {
        return x >= 'A' && x <= 'Z' ? x - 'A' + 26 : x - 'a';
    }

    public String minWindow(String s, String t) {

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (char c : chart) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int len = chars.length, j = -1;
        int minLen = len + 2;
        String ans = "";
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            while (checkSContainsT(tMap, sMap)) {
                char t1 = chars[++j];
                if (i + 1 - j < minLen) {
                    minLen = i + 1 - j;
                    ans = s.substring(j, i + 1);
                }
                sMap.put(t1, sMap.getOrDefault(t1, 0) - 1);
            }
        }
        return ans;
    }

    private boolean checkSContainsT(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        for (Character character : tMap.keySet()) {
            if (!sMap.containsKey(character) || sMap.get(character) < tMap.get(character)) return false;
        }
        return true;
    }
}
