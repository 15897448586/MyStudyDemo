package TargetOffer;

import Structure.TreeNode;

/**
 * @Author zlx
 * @Date 2024/4/23 0:23
 */
public class Solution23 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
