package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/18 18:24
 */
public class Solution13 {
    public double myPow(double x, int n) {
        if (x == 0) return  0;
        if (x == 1) return 1;
        if (x == -1) return n % 2 == 1 ? -1 : 1;
        long N = n;
        return N >= 0 ? fastPow(x, N) : 1 / fastPow( x , -N);
    }

    public double fastPow(double base, long ex) {
        double sum = 1;
        while (ex > 0) {
            if (ex % 2 == 1) {
                sum *= base;
            }
            base *= base;
            ex >>= 1;
        }
        return sum;
    }
}
