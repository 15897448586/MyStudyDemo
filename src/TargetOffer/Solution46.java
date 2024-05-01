package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/30 15:35
 */
public class Solution46 {
    public int firstUniqChar(String s) {
        int[][] r = new int[26][2];
        int n = s.length();
        char[] chs = s.toCharArray();
        int res = -1;
        for (int i = 0; i < n; i++) {
            int a = chs[i] - 'a';
            if (r[a][0] == 0) {
                r[a][0] = i;
            }
            r[a][1]++;
        }
        for (int i = 0; i < 26; i++) {
            if (r[i][1] == 1) {
                if (res == -1) res = r[i][0];
                else res = Math.min(res, r[i][0]);
            }
        }
        return res;
    }
}
