package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/23 0:31
 */
public class Solution24 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left != right) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
