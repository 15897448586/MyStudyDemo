package CodeBrainstorming.LinkedList;

import Structure.ListNode;

/**
 * @Author zlx
 * @Date 2024/5/15 17:57
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            ListNode next = cur.next;
            if (next.val == val) {
                cur.next = next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
