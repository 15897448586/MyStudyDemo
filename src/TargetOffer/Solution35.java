package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/23 22:14
 */
public class Solution35 {
    /**
     * 摩尔计数 由于是多数，因此，相等时会贵0，把所有相同的抵消掉，最后一定能拿到多数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int number = 0;
        for (int num : nums) {
            if (count == 0) {
                number = num;
            }
            count = number == num ? count + 1 : count - 1;
        }
        return number;
    }
}
