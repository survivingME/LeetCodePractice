package LCNQ;

import domain.ListNode;

public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode p = head;
        int len = 1;
        while(p.next != null) {
            len++;
            p = p.next;
        }
        k %= len;
        p.next = head;
        for(int i = 1;i < len - k;i++) {
            head = head.next;
        }
        p = head;
        head = head.next;
        p.next = null;
        return head;
    }
}
