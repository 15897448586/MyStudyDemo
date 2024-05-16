package CodeBrainstorming.LinkedList;

import Structure.ListNode;

/**
 * @Author zlx
 * @Date 2024/5/16 16:28
 */
public class Solution206 {
    public ListNode reverseList01(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
