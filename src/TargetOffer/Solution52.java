package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/5/2 0:29
 */
public class Solution52 {
    public int[] singleNumber(int[] nums) {
        int xorAll = 0;
        for (int num : nums) {
            xorAll ^= num;
        }
        int lowBit = xorAll & -xorAll;
        int[] ans = new int[2];
        for (int num : nums) {
            ans[(num & lowBit) == 0 ? 0 : 1] ^= num;
        }
        return ans;
    }
}
