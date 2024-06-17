package leetcode;

/**
 * @Author zlx
 * @Date 2024/6/14 16:38
 */
public class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        int len = s.length(), i = 1;
        for (; i < len; i++) {
            if (s.charAt(i) - '0' < s.charAt(i - 1) - '0') {
                break;
            }
        }
        // 证明是单调递增的，返回自己就行
        if (i == len) return n;
        int i1 = Integer.parseInt(s.substring(0, i)) - 1;
        StringBuilder sb = new StringBuilder(String.valueOf(i1));
        for (; i < len; i++) {
            sb.append('9');
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution738().monotoneIncreasingDigits(332));
    }
}
