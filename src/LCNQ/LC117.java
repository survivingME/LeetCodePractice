package LCNQ;

import java.util.LinkedList;
import java.util.Queue;

public class LC117 {
//    if(root == null) return null;
//    Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()) {
//        int size = queue.size();
//        for(int i = 0;i < size;i++) {
//            Node poll = queue.poll();
//            if(i == size - 1) poll.next = null;
//            else poll.next = queue.peek();
//            if(poll.left != null) queue.add(poll.left);
//            if(poll.right != null) queue.add(poll.right);
//        }
//    }
//    return root;
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.left != null && root.right != null) root.left.next = root.right;
        if(root.left != null && root.right == null) root.left.next = getNode(root.next);
        if(root.right != null) root.right.next = getNode(root.next);

        connect(root.left);
        connect(root.right);
        return root;
    }

    public Node getNode(Node root) {
        if(root == null) return null;
        if(root.left != null) return root.left;
        if(root.right != null) return root.right;
        if(root.next != null) return getNode(root.next);
        return null;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
