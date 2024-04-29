package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/25 20:12
 */
public class Solution40 {
    static long[] map = new long[12];
    static {
        map[1] = 9;
        for(int i = 2; i < map.length; i++) {
            map[i] = 1L * map[i - 1] * 10;
        }
    }
    public int findNthDigit(int n) {
        int digit = 1;
        while (n > 0) {
            if (digit == map.length) break;
            if (n > digit * map[digit]) {
                n -= digit * map[digit];
                digit++;
            }else{
                break;
            }
        }
        // 余数
        int temp = n % digit;
        int t = n / digit;
        int d = (int)Math.pow(10, digit - 1) + t - 1;
        if (temp == 0) return d % 10;
        else {
            d = d + 1;
            while (digit - temp > 0) {
                d /= 10;
                temp++;
            }
            return d % 10;
        }
    }
    public static void main(String[] args) {
        Solution40 s = new Solution40();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6000; i++) {
            sb.append(i);
        }
        System.out.println(s.findNthDigit(172));
//        for (int i = 1; i < 10000; i++) {
//            if(s.findNthDigit(i) != (sb.charAt(i) - '0')) {
//                System.out.println(i);
//            }
//        }
    }
}
