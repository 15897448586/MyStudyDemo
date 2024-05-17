package CodeBrainstorming.Hash;

import java.util.HashSet;

/**
 * @Author zlx
 * @Date 2024/5/17 15:05
 */
public class Solution202 {
    public boolean isHappy(int n) {
        Long N = (long)n;
        HashSet<Long> set = new HashSet<>();
        while (N != 1) {
            if (set.contains(N)) return false;
            set.add(N);
            N =count(N);
        }
        return true;
    }

    private Long count(long n) {
        long sum = 0;
        while (n != 0) {
            int t = (int)(n % 10);
            sum += t * t;
            n /= 10;
        }
        return sum;
    }
}
