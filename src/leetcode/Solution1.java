package leetcode;

import Structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zlx
 * @Date 2024/4/24 16:42
 */
public class Solution1 {
    private Map<Integer,Integer> map =  new HashMap<>();
    private int target;

    private int max = -1;
    public int amountOfTime(TreeNode root, int start) {
        // 处理特殊情况
        if (root == null || (root.left == null && root.right == null && start == root.val)) return 0;
        // 确定子树的高度
        target = start;
        return 0;
    }

    private int find(TreeNode root) {
        // 没找到返回-1
        if (root == null) return -1;
        // 找到了返回1
        if (root.val == target) {
            // 当前节点到子树的最大高度
            int depth = getDepth(root);
            max = depth - 1;
            map.put(root.val, depth - 1);
            return 1;
        }
        //在左子树找
        int left = find(root.left);
//        boolean right = find(root.right);
        return 0;
    }


    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        // 直接返回已经包含的节点的数据
        if (map.containsKey(root.val)) return map.get(root.val);
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
