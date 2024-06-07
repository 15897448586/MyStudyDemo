package CodeBrainstorming.BinaryTree;

import Structure.TreeNode;

/**
 * @Author zlx
 * @Date 2024/6/4 17:01
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int  i, int j) {
        if (i < j) return null;
        int[] max = getMax(nums, i, j);
        if (max[0] == -1) return null;
        TreeNode root = new TreeNode(max[0]);
        root.left = dfs(nums, i, max[1] - 1);
        root.right = dfs(nums, max[1] + 1, j);
        return root;
    }

    private int[] getMax(int[] nums, int i, int j) {
        int[] ans = {-1, -1};
        for (int k = i; k <= j; k++) {
            if (nums[k] > ans[0]) {
                ans[0] = nums[k];
                ans[1] = k;
            }
        }
        return ans;
    }
}
