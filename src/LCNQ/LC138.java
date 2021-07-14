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
        if(head == null) return head;
        HashMap<Node, Node> vis = new HashMap<>();
        Node p = head;
        Node c = new Node(p.val);
        vis.put(p, c);
        while(p != null) {
            if(vis.containsKey(p.random)) {
                c.random = vis.get(p.random);
            } else if(p.random == null) {
                c.random = null;
            } else {
                c.random = new Node(p.random.val);
                vis.put(p.random, c.random);
            }
            if(vis.containsKey(p.next)) {
                c.next = vis.get(p.next);
            } else if(p.next == null) {
                c.next = null;
            } else {
                c.next = new Node(p.next.val);
                vis.put(p.next, c.next);
            }
            p = p.next;
            c = c.next;
        }
        return vis.get(head);

    }
}
