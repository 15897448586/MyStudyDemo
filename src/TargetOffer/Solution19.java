package TargetOffer;

import Structure.ListNode;

/**
 * @Author zlx
 * @Date 2024/4/22 23:34
 */
public class Solution19 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        if (fast == null) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
