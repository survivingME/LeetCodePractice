package LCNQ;

import Domain.ListNode;

public class LC203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        /**
         * prev指针保存命中元素之前的元素
         */
        ListNode prev = dummy, cur = head;
        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);

        ListNode res = new LC203().removeElements(head, 7);
    }
}
