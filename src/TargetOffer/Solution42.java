package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/30 13:30
 */
public class Solution42 {
    public int numDecodings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        int dp[] = new int[n + 1];
        dp[0] =1; dp[1] = 1;
        for (int i = 2; i < n + 1 ; i++) {
            int c = chars[i - 1] - '0';
            if (c == 0) {
                // 在这种情况情况下，只有一种解码方式，即前一个字符为1或2，同时受改字符的影响
                if (isOneOrTwo(chars[i - 2])) {
                    // 有一种特殊情况
                    if (i - 3 >= 0 && isOneOrTwo(chars[i - 3])) {
                        dp[i - 1] = dp[i - 2];
                    }
                    dp[i] = dp[i - 1];
                }else{
                    return 0;
                }
            } else if (c <= 6) {
                if (isOneOrTwo(chars[i - 2])) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }else{
                    dp[i] = dp[i - 1];
                }
            }else{
                if (chars[i - 2] == '1') {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[n];
    }

    private boolean isOneOrTwo(char c) {
        return c == '1' || c == '2';
    }

    public static void main(String[] args) {
        Solution42 s = new Solution42();
        System.out.println(s.numDecodings("12"));
        System.out.println(s.numDecodings("226"));
        System.out.println(s.numDecodings("06"));
        System.out.println(s.numDecodings("21010"));
    }
}
