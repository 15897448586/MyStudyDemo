package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/30 14:50
 */
public class Solution43 {
    public int jewelleryValue(int[][] frame) {
        int m = frame.length;
        int n = frame[0].length;
        for (int i = 1; i < m; i++) {
            frame[i][0] += frame[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            frame[0][i] += frame[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                frame[i][j] += Math.max(frame[i][j - 1], frame[i - 1][j]);
            }
        }
        return frame[m - 1][n - 1];
    }
}
