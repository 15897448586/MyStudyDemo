package CodeBrainstorming.Hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zlx
 * @Date 2024/5/17 12:47
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = s.length(), n = p.length();
        if (m < n) return ans;
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        char[] chars = s.toCharArray();
        int[] cs = new int[26];
        for (int i = 0; i < n; i++) {
            cs[chars[i] - 'a']++;
        }
        if (check(cnt, cs)) ans.add(0);
        for (int i = n; i < m; i++) {
            int j = i - n;
            cs[chars[i] - 'a']++;
            cs[chars[j] - 'a']--;
            if (check(cnt, cs)) ans.add(j + 1);
        }
        return ans;
    }

    private boolean check(int[] cnt, int[] cnts) {
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != cnts[i]) return false;
        }
        return true;
    }
}

