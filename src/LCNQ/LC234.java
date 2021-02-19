package LCNQ;

import domain.ListNode;

public class LC234 {
    public boolean isPalindrome(ListNode head) {
        ListNode f = head, s = head;
        while(f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        if(f != null) s = s.next;
        s = reverse(s);
        f = head;
        while(s != null) {
            if(s.val != f.val) return false;
            s = s.next;
            f = f.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head, tmp = head;
        while(cur != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
