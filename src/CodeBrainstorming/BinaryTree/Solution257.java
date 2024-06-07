package CodeBrainstorming.BinaryTree;

import Structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zlx
 * @Date 2024/6/4 16:00
 */
public class Solution257 {
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ans;
    }

    private void dfs(TreeNode root, String path) {
        if (root != null) {
            StringBuilder sb =  new StringBuilder(path);
            sb.append(root.val);
            if (root.left == null && root.right == null) {
                ans.add(sb.toString());
            }else {
                sb.append("->");
                dfs(root.left,sb.toString());
                dfs(root.right,sb.toString());
            }
        }
    }
}
