package TargetOffer;

import java.util.HashSet;

/**
 * @Author zlx
 * @Date 2024/4/30 14:57
 */
public class Solution44 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int n = chs.length;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        int l = 0, r = 0;
        for (;r < n; r++) {
            char c = chs[r];
            if (set.contains(c)) {
                while (l < r) {
                    char d = chs[l];
                    set.remove(d);
                    l++;
                    if (d == c) {
                        break;
                    }
                }
            }
            set.add(c);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution44 s = new Solution44();
        String[] ss = {"tmmzuxt","abcabcbb", "bbbbb", "pwwkew", "aab", "dvdf"};
        for (String s1 : ss) {
            System.out.println(s.lengthOfLongestSubstring(s1));
        }
    }
}
