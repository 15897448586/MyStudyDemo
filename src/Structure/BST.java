package Structure;

import Interface.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树
 * @Author zlx
 * @Date 2024/4/23 14:37
 */
public class BST {

    /**
     * 头节点
      */
    private TreeNode root;

    public void insert(int val) {
        root = insertNode(root, val);
    }

    private TreeNode insertNode(TreeNode node, int val){
        if (node == null) {
            return new TreeNode(val);
        }
        if (val > node.val) {
            node.right = insertNode(node.right, val);
        }else {
            node.left = insertNode(node.left, val);
        }
        return node;
    }
    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            postorder(node.left, result);
            result.add(node.val);
            postorder(node.right, result);
        }
    }

    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            postorder(node.left, result);
            postorder(node.right, result);
        }
    }

    public List<Integer> postorderTraversal() {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            postorder(node.left, result);
            postorder(node.right, result);
            result.add(node.val);
        }
    }


    public TreeNode buildTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
        return root;
    }

    public TreeNode buildTree(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            insert(nums.get(i));
        }
        return root;
    }

    public int[] convertToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
