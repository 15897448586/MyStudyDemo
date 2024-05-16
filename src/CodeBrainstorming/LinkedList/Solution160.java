package CodeBrainstorming.LinkedList;

import Structure.ListNode;

/**
 * @Author zlx
 * @Date 2024/5/16 18:00
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA, t2 = headB;
        while (t1 != t2) {
            t1 = t1 == null? headB :t1.next;
            t2 = t2 == null? headA: t2.next;
        }
        return t1;
    }
}
