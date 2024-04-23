package TargetOffer;

import Structure.ListNode;

/**
 * 反转链表的同时得到数量
 * @Author zlx
 * @Date 2024/4/16 12:55
 */
public class Solution4 {
    int count = 0;
    public int[] reverseBookList(ListNode head) {
        if (head == null) return new int[]{};
        ListNode node = reverseList(head);
        int[] ans = new int[count];
        for (int i = 0; i < count; i++) {
            ans[i] = node.val;
            node = node.next;
        }
        return ans;
    }

    // 1.反转链表
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            count++;
            ListNode next = head.next;
            head.next =pre;
            pre = head;
            head =next;
        }
        return pre;
    }
}
