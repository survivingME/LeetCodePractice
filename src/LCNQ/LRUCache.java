package LCNQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LRUCache {
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int k;
    public int[] LRU (int[][] operators, int k) {
        // write code here
        this.k = k;
        head.next = tail;
        tail.prev = head;
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < operators.length;i++) {
            if(operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else if(operators[i][0] == 2) {
                res.add(get(operators[i][1]));
            }
        }
        int[] ra = new int[res.size()];
        for(int i = 0; i < res.size();i++) ra[i] = res.get(i);
        return ra;
    }

    public void set(int key, int val) {
        if(get(key) != -1) {
            map.get(key).val = val;
        } else {
            if(map.size() == k) {
                int rk = tail.prev.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                map.remove(rk);
            }
            Node node = new Node(key, val);
            map.put(key, node);
            moveToHead(node);
        }
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
            return node.val;
        }
        else return -1;
    }

    public void moveToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    static class Node {
        int key, val;
        Node prev, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}