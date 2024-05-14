package CodeBrainstorming.Array.RemoveElement;

/**
 * @Author zlx
 * @Date 2024/5/14 18:05
 */
public class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        int min = Integer.MAX_VALUE, index = 0;
        while (i < n) {
            nums[i] = nums[i] * nums[i];
            if (nums[i] < min) {
                index = i;
                min = nums[i];
            }
            i++;
        }
        i = 0;
        res[i++] = nums[index];
        int l = index - 1, r = index + 1;
        while (l >= 0 && r < n) {
            if (nums[l] <= nums[r]) {
                res[i++] = nums[l--];
            }else{
                res[i++] = nums[r++];
            }
        }
        while (l >= 0) {
            res[i++] = nums[l--];
        }
        while (r < n) {
            res[i++] = nums[r++];
        }
        return res;
    }

    public int[] sortedSquares01(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        new Solution977().sortedSquares(nums);
    }
}
