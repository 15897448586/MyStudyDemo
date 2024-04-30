package TargetOffer;

import Structure.ListNode;

/**
 * @Author zlx
 * @Date 2024/4/30 17:10
 */
public class Solution48 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode p1=headA,p2 =headB;
        while(p1!=p2){
            p1=p1==null?headB:p1.next;
            p2=p2==null?headA:p2.next;
        }
        return p1;
    }
}
