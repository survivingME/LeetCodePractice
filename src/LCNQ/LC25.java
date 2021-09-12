package LCNQ;

import Domain.ListNode;

public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode a = head, b = head;
        for(int i = 0;i < k;i++) {
            if(b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = null, cur = a, tmp;
        while(cur != b) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
