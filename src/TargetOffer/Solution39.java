package TargetOffer;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * @Author zlx
 * @Date 2024/4/25 15:16
 */
public class Solution39 {
    // 记录几位数有几个1
    public int countDigitOne(int n) {
        if (n <= 1) return n;
        int res = 0;
        int high = n / 10, cur = n % 10, low = 0, digit = 1;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + 1 +low;
            }else {
                res +=  (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
