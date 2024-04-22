package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/22 23:25
 */
public class Solution18 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        if (count < n) return head;
        if (count == n) return head.next;
        cur =  head;
        for (int i = 1; i < count - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
