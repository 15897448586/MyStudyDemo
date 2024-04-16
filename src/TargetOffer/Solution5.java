package TargetOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 前序遍历中头节点首先遍历，中序遍历中头节点位于中间
 * 根据头节点的位置确定左右子树
 * @Author zlx
 * @Date 2024/4/16 13:49
 */
public class Solution5 {

    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 1.校验特殊情况
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) return null;
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        // 1.建立头节点
        TreeNode root = new TreeNode(preorder[preStart]);
        // 2.找到头节点在中序遍历中的位置
        int rootIndex = map.get(preorder[preStart]);
        // 计算左子树的长度
        int length = rootIndex - inStart;
        root.left = dfs(preorder, inorder, preStart + 1, preStart + length, inStart, rootIndex - 1);
        root.right = dfs(preorder, inorder, preStart + length + 1, preEnd, rootIndex + 1, inEnd);
        return root;
    }
}
