package CodeBrainstorming.String;

/**
 * @Author zlx
 * @Date 2024/5/20 14:39
 */
public class Solution541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i = i + 2 * k) {
            int r = i + k - 1;
            reverse(chars, i, Math.min(r, n - 1));
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(new Solution541().reverseStr(s, 2));
    }
}
