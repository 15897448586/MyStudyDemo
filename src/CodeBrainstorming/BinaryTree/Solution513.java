package CodeBrainstorming.BinaryTree;

import Structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author zlx
 * @Date 2024/6/4 16:44
 */
public class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        int res = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                if (i == 0) res = poll.val;
                if (poll.left != null) q.offer(poll.left);
                if (poll.right != null) q.offer(poll.right);
            }
        }
        return res;
    }
}
