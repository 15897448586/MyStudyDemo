package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/18 17:50
 */
public class Solution12 {
    class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            // 第一种遍历每一位
//        while (n != 0) {
//            if ((n & 1) == 1) {
//                count++;
//            }
//            n >>= 1;
//        }
//        return count;
            // 第二种将最低位变为0，执行次数位1的个数
            while (n != 0) {
                n &= (n - 1);
                count++;
            }
            return count;
        }
    }
}
