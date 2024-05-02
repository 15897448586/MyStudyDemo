package TargetOffer;

import Structure.TreeNode;

/**
 * @Author zlx
 * @Date 2024/5/2 0:10
 */
public class Solution50 {
    private int k;
    private int ans;
    public int kthSmallest(TreeNode root, int k) {
        k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null || k <= 0) return;
        dfs(root.left);
        if (--k == 0) ans = root.val;
        dfs(root.right);
    }
}
