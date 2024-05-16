package CodeBrainstorming.LinkedList;

import Structure.ListNode;

/**
 * @Author zlx
 * @Date 2024/5/16 16:35
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode doumy =  new ListNode(-1);
        doumy.next = head;
        ListNode cur = doumy;
        while (cur != null && cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            cur.next = second;
            second.next = first;
            cur = cur.next.next;
        }
        return doumy.next;
    }
}
