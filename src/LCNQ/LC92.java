package LCNQ;

import domain.ListNode;

public class LC92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null, cur = head;
        int m = left, n = right;
        while(m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode conn = prev;
        ListNode tail = cur;
        ListNode tmp = null;
        while(n > 0) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            n--;
        }
        if(conn != null) conn.next = prev;
        else head = prev;
        tail.next = cur;
        return head;
    }
}
