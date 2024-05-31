package CodeBrainstorming.BinaryTree;

import Structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author zlx
 * @Date 2024/5/31 14:44
 */
public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left !=  null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            ans.add(sum / size);
        }
        return ans;
    }
}
