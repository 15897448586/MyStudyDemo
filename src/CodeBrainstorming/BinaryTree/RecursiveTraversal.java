package CodeBrainstorming.BinaryTree;

import Structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**递归遍历
 * @Author zlx
 * @Date 2024/5/30 16:07
 */
public class RecursiveTraversal {
    /**
     * 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversal(root, ans);
        return ans;
    }

    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        return null;
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        return null;
    }
}
