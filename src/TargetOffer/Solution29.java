package TargetOffer;

import Structure.BST;

import java.util.Arrays;

/**
 * @Author zlx
 * @Date 2024/4/23 14:05
 */
public class Solution29 {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = {5,9,8,1,4,7,3,6,2};
        bst.buildTree(arr);
        int[] sequential_sequence = bst.convertToArray(bst.postorderTraversal());
        System.out.println(verifyPostorder(sequential_sequence));
        sequential_sequence = bst.convertToArray(bst.preorderTraversal());
        System.out.println(verifyPostorder(sequential_sequence));
        sequential_sequence = bst.convertToArray(bst.inorderTraversal());
        System.out.println(verifyPostorder(sequential_sequence));
        sequential_sequence = new  int[]{7,6,5,4};
        System.out.println(verifyPostorder(sequential_sequence));
    }

//    public static boolean verifyPostorder(int [] sequence){
//        if(sequence == null || sequence.length <= 0){
//            return false;
//        }
//        int len = sequence.length;
//        int root = sequence[len - 1];
//        int i = 0;
//        for(; i < len - 1; i++){
//            if(root <= sequence[i]){
//                break;
//            }
//        }
//        int j = i;
//        for(; j < len - 1; j++){
//            if(root > sequence[j]){
//                return false;
//            }
//        }
//        boolean leftFlag = true;
//        if (i > 0){
//            leftFlag = verifyPostorder(Arrays.copyOfRange(sequence, 0, i));
//        }
//        boolean rightFlag = true;
//        if(i < len - 1){
//            rightFlag = verifyPostorder(Arrays.copyOfRange(sequence, i, sequence.length - 1));
//        }
//        return leftFlag && rightFlag;
//    }

    public static boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) return false;
        return divideAndConquer(postorder, 0 , postorder.length - 1);
    }

    private static boolean divideAndConquer(int[] postorder, int start, int end) {
        if (start >= end) return true;
        int root = postorder[end];
        int l ;
        for (l = start; l < end; l++) {
            if (postorder[l] > root) break;
        }
        for (int i = l; i < end; i++) {
            if (postorder[i] < root) return false;
        }
        boolean left = divideAndConquer(postorder, start, l - 1);
        boolean right = divideAndConquer(postorder, l, end - 1);
        return left && right;
    }
}
