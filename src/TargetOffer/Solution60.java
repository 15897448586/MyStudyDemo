package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/5/6 17:35
 */
public class Solution60 {
    public int mechanicalAccumulator(int target) {
        boolean x = target > 0 && (target += mechanicalAccumulator(target - 1))> 0;
        return target;
    }

}
