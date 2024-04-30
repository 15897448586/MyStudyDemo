package TargetOffer;

import java.util.Arrays;

/**
 * @Author zlx
 * @Date 2024/4/30 11:14
 */
public class Solution41 {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        // 1.数字转字符串
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        });
        for (int num : nums) {
            sb.append(num);
        }
        // 避免出现全是0的情况
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0'){
            i++;
        }
        return sb.substring(i);
    }
}
