package LCNQ;

import Domain.ListNode;

public class LC143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode f = head, l = head;
        while(f.next != null && f.next.next != null) {
            l = l.next;
            f = f.next.next;
        }
        ListNode nHead = l.next;
        l.next = null;
        ListNode tmp, prev = null;
        while(nHead != null) {
            tmp = nHead.next;
            nHead.next = prev;
            prev = nHead;
            nHead = tmp;
        }
        while(head != null && prev != null) {
            ListNode hn = head.next;
            ListNode pn = prev.next;

            head.next = prev;
            head = hn;

            prev.next = head;
            prev = pn;
        }
    }
}
