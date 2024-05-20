package CodeBrainstorming.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zlx
 * @Date 2024/5/17 15:19
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        // 枚举第一个节点 ，时间复杂度为o(n^2)
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int second = first + 1, third = n - 1;
            while (second < third) {
                // 左侧去重
                while (second < third && (second > first + 1) && nums[second] == nums[second - 1]) {
                    second++;
                }
                // 右侧去重
                while (second < third && third < n - 1 && nums[third] == nums[third + 1] ) {
                    third--;
                }
                // 避免上述去重后导致sec==thr
                if (second == third) break;
                // 求和
                int sum = nums[first] + nums[second] + nums[third];
                if (sum > 0) {
                    third--;
                } else if (sum < 0) {
                    second++;
                }else{
                    ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    // 比较下一个，如果不加会死循环
                    second++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        System.out.println(new Solution15().threeSum(nums).size());
    }
}
