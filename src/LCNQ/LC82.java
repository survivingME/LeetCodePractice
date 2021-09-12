package LCNQ;

import Domain.ListNode;

public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, cur = head.next;
        while(cur != null) {
            if(prev.next.val != cur.val) {
                prev = prev.next;
                cur = cur.next;
            } else {
                while(cur.next != null && cur.next.val == cur.val) cur = cur.next;
                prev.next = cur.next;
                if(cur.next == null) break;
                cur = cur.next.next;
            }
        }
        return dummy.next;
    }
}
