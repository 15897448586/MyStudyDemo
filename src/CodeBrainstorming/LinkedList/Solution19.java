package CodeBrainstorming.LinkedList;

import Structure.ListNode;

/**
 * @Author zlx
 * @Date 2024/5/16 17:56
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode doumy = new ListNode(-1);
        doumy.next = head;
        remove(doumy, n);
        return doumy.next;
    }
    public int remove(ListNode head, int n) {
        if (head == null) return 0;
        int index = remove(head.next, n) + 1;
        if (index == n + 1) {
            head.next = head.next.next;
        }
        return index;
    }
}
