package CodeBrainstorming.Hash;

/**
 * @Author zlx
 * @Date 2024/5/17 11:55
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] sa = new int[26];
        int[] ta = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sa[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            ta[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sa[i] != ta[i]) return false;
        }
        return true;
    }
}
