package CodeBrainstorming.Array.BinarySearch;

/**
 * @Author zlx
 * @Date 2024/5/14 16:55
 */
public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        int l = 2,  r = x / 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == x / mid) return mid;
            else if (mid > x / mid) {
                r = mid - 1;
            }else if (mid < x / mid) {
                if (mid + 1 > x / (mid + 1)) return mid;
                l = mid + 1;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        new Solution69().mySqrt(8);
    }
}
