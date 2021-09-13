package LCNQ;

import Domain.ListNode;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode f = dummy, l = dummy;
        for(int i = 0;i < n;i++) f = f.next;
        while(f.next != null) {
            l = l.next;
            f = f.next;
        }
        l.next = l.next.next;
        return dummy.next;
    }
}
