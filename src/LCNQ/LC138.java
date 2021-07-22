package LCNQ;

import java.util.HashMap;

public class LC138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        Node c = new Node(p.val);
        map.put(p, c);
        while(p != null) {
            if(map.containsKey(p.random)) {
                c.random = map.get(p.random);
            } else if(p.random == null) {
                c.random = null;
            } else {
                c.random = new Node(p.random.val);
                map.put(p.random, c.random);
            }
            if(map.containsKey(p.next)) {
                c.next = map.get(p.next);
            } else if(p.next == null) {
                c.next = null;
            } else {
                c.next = new Node(p.next.val);
                map.put(p.next, c.next);
            }
            p = p.next;
            c = c.next;
        }
        return map.get(head);
    }
}
