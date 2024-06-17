package CodeBrainstorming.DP;

/**
 * @Author zlx
 * @Date 2024/6/17 21:07
 */
public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        //i个0，j个1的最大子集数量为dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        // 遍历物品
        for (String str : strs) {
            int[] cnt = count(str);
            for (int i = m; i >= cnt[0]; i--) {
                for (int j = 0; j >= cnt[1] ; j--) {
                    dp[i][j] = Math.max(dp[i - cnt[0]][j - cnt[1]] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String str) {
        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                a++;
            }
        }
        return new int[]{a, str.length() - a};
    }
}
