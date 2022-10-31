package pro146;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LRUCache2 {

    private int capacity;

    private Map<Integer, Node> map;

    private Node head;

    private Node tail;

    static class Node {

        Integer key;

        Integer value;

        Node prev;

        Node next;

        Node(Integer key, Integer num, Node pre, Node next) {
            this.key = key;
            this.value = num;
//            this.pre = pre;
//            this.next = next;
//            if(pre != null) pre.next = this;
//            if(next != null) next.pre = this;
        }

        void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
    }

    public LRUCache2(int capacity) {
        map = new HashMap<>();
        head = new Node(null, null, null, null);
        tail = new Node(null, null, null, null);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);

            moveToHead(node);

            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node current = map.get(key);
            current.value = value;
            moveToHead(current);
        } else {
            Node newNode = new Node(key, value, head, head.next);
            addToHead(newNode);

            map.put(key, newNode);
            if(map.size()> capacity) {

                Node removeNode = removeTail();
                map.remove(removeNode.key);
            }
        }
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    public static void main(String[] argv) {
        LRUCache2 cache2 = new LRUCache2(2);
        cache2.put(1, 1);
        cache2.put(2,2);
        cache2.get(1);
        cache2.put(3, 3);
        cache2.get(2);
        cache2.put(4, 4);
        cache2.get(1);
        cache2.get(3);
        cache2.get(4);
    }

}
