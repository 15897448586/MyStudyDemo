package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/5/6 17:07
 */
public class Solution58 {
    public int iceBreakingGame(int num, int target) {
        int ans = 0;
        for (int i = 2; i <= num; i++) {
            ans = (ans + target) % i;
        }
        return ans;
    }

}
