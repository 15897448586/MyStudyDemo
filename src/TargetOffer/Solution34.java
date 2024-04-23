package TargetOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zlx
 * @Date 2024/4/23 21:09
 */
public class Solution34 {

    // 第一种不存在重复数字
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        boolean[] used = new boolean[nums.length];
        backtrace(nums, new ArrayList<>(), ans, used);
        return ans;
    }

    private void backtrace(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] used) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            backtrace(nums, list, ans, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    // 第二种 存在重复数字
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtraceUnique(nums, ans, new ArrayList<Integer>(), used);
        return ans;
    }

    private void backtraceUnique(int[] nums, List<List<Integer>> ans, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                backtraceUnique(nums, ans, list, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}
