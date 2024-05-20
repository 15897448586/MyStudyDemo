package CodeBrainstorming.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zlx
 * @Date 2024/5/20 12:02
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                int third = second + 1, fourth = n - 1;
                long remain = (long) target - nums[first] - nums[second];
                while (third < fourth) {
                    while (third < fourth && third > second + 1 && nums[third] == nums[third - 1]) third++;
                    while (third < fourth && fourth < n - 1 && nums[fourth] == nums[fourth + 1]) fourth--;

                    if (third == fourth) break;
                    long sum = nums[third] + nums[fourth];
                    if (sum < remain) {
                        third++;
                    } else if (sum > remain) {
                        fourth--;
                    }else {
                        ans.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        third++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0};
        List<List<Integer>> lists = new Solution18().fourSum(nums, 0);
        System.out.println(lists);
    }
}
