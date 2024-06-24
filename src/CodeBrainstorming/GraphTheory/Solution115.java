package CodeBrainstorming.GraphTheory;

/**
 * @Author zlx
 * @Date 2024/6/22 14:38
 */
public class Solution115 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (chs[i - 1] == cht[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
