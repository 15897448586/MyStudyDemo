package CodeBrainstorming.BinaryTree;

import Structure.TreeNode;

/**
 * @Author zlx
 * @Date 2024/5/31 15:39
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3, 6, 9};
        int i = 0;
        TreeNode root = new TreeNode(arr[i++]);
        root.left = new TreeNode(arr[i++]);
        root.right = new TreeNode(arr[i++]);
        root.left.left = new TreeNode(arr[i++]);
        root.left.right = new TreeNode(arr[i++]);
        root.right.left = new TreeNode(arr[i++]);
        root.right.right = new TreeNode(arr[i++]);
        new Solution226().invertTree(root);
    }
}
