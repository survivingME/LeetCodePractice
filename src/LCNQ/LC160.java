package LCNQ;

import Domain.ListNode;

public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        ListNode at = null, bt = null;
        while(true) {
            if(a == b) return a;
            if(a.next != null) a = a.next;
            else {
                at = a;
                a = headB;
                if(bt != null && at != bt) return null;
            }
            if(b.next != null) b = b.next;
            else {
                bt = b;
                b = headA;
                if(at != null && at != bt) return null;
            }
        }
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while(a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
