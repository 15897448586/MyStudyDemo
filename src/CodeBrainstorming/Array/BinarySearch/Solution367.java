package CodeBrainstorming.Array.BinarySearch;

/**
 * @Author zlx
 * @Date 2024/5/14 17:12
 */
public class Solution367 {
    public boolean isPerfectSquare(int x) {
        if (x == 1) return true;
        if (x < 4) return false;
        int l = 2,  r = x / 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == x / mid) return true;
            else if (mid > x / mid) {
                r = mid - 1;
            }else if (mid < x / mid) {
                if (mid + 1 > x / (mid + 1)) return false;
                l = mid + 1;
            }
        }
        return false;
    }
}
