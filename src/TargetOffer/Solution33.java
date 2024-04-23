package TargetOffer;

import Structure.TreeNode;

import java.util.*;

/**
 * @Author zlx
 * @Date 2024/4/23 17:33
 */
public class Solution33 {

    /**
     * 推测leetcode的序列化方式
     */
    // bfs 序列化
    private static final String INF = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append(INF);
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] strs = data.split(",");
        int n = strs.length;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        int index = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (index < n && !INF.equals(strs[index])) {
                node.left = new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(node.left);
            }
            index++;
            if (index < n && !INF.equals(strs[index])) {
                node.right = new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }

    /**
     * 先序遍历
     *
     * @param
     * @return
     */
    class Codec1 {
        public String serialize(TreeNode root) {
            if (root == null) return "null";
            return serialize(root.left) + "," + serialize(root.right) + "," + root.val;
        }

        public TreeNode deserialize(String data) {
            String[] req = data.split(",");
            ArrayList<String> r = new ArrayList<>(Arrays.asList(req));
            return dfsdeserialize(r);
        }

        public TreeNode dfsdeserialize(ArrayList<String> r) {
            if ("null".equals(r.get(r.size() - 1))) {
                r.remove(r.size() - 1);
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(r.get(r.size() - 1)));
            r.remove(r.size() - 1);
            node.right = dfsdeserialize(r);
            node.left = dfsdeserialize(r);
            return node;
        }
    }

    class Codec2 {
        public String serialize(TreeNode root) {
            if (root == null) return "null";
            return serialize(root.left) + "," + serialize(root.right) + "," + root.val;
        }

        public TreeNode deserialize(String data) {
            String[] req = data.split(",");
            ArrayList<String> r = new ArrayList<>(Arrays.asList(req));
            return dfsdeserialize(r);
        }

        public TreeNode dfsdeserialize(ArrayList<String> r) {
            if ("null".equals(r.get(r.size() - 1))) {
                r.remove(r.size() - 1);
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(r.get(r.size() - 1)));
            r.remove(r.size() - 1);
            node.right = dfsdeserialize(r);
            node.left = dfsdeserialize(r);
            return node;
        }
    }

}
