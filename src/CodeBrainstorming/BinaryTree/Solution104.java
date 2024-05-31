package CodeBrainstorming.BinaryTree;

import Structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author zlx
 * @Date 2024/5/31 15:21
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return maxDepth;
    }
}
