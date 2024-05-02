package TargetOffer;

import Structure.TreeNode;

/**
 * @Author zlx
 * @Date 2024/5/2 0:18
 */
public class Solution51 {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}