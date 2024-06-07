package CodeBrainstorming.BinaryTree;

import Structure.TreeNode;

/**
 * @Author zlx
 * @Date 2024/6/4 16:16
 */
public class Solution404 {
    private int ans;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode root) {
        if (root.left ==  null && root.right == null)  {
            return root.val;
        }
        int l = dfs(root.left);
        if (l > -2000) ans += l;
        int r = dfs(root.right);
        return -2000;
    }
}
