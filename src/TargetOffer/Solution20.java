package TargetOffer;

import Structure.ListNode;

/**
 * @Author zlx
 * @Date 2024/4/22 23:48
 */
public class Solution20 {
    // 迭代
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseList = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return  reverseList;
    }
}
