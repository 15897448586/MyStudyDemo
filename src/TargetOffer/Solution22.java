package TargetOffer;

import Structure.TreeNode;

/**
 * @Author zlx
 * @Date 2024/4/23 0:09
 */
public class Solution22 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return same(root,subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean same(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null || root.val != subRoot.val) return false;
        return root.val == subRoot.val && same(root.left, subRoot.left) && same(root.right, subRoot.right);
    }
}
