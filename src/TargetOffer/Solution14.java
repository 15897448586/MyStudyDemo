package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/18 22:35
 */
public class Solution14 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
