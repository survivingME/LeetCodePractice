package LCNQ;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer, Node> map;
    Node head, tail;
    int k;

    public LRUCache(int capacity) {
        this.k = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(get(key) != -1) {
            Node node = map.get(key);
            node.value = value;
        } else {
            if(map.size() == k) {
                map.remove(tail.prev.key);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
            }
            Node node = new Node(key, value);
            map.put(key, node);
            moveToHead(node);
        }
    }

    public void moveToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    class Node {
        int key, value;
        Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
