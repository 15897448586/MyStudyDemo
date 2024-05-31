package CodeBrainstorming.BinaryTree;

import Structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author zlx
 * @Date 2024/5/31 15:27
 */
public class Solution111 {

    public int minDepth01(TreeNode root) {
        if (root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        return root.left == null || root.right == null ? l + r + 1 : Math.min(l, r) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int min = Integer.MAX_VALUE;
        int minDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) min = Math.min(min, minDepth);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return min;
    }
}
