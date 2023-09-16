package leetcode.pro146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache3 {

    public class Node {
        Node pre;
        Node next;
        int key;
        int value;
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache3(int capacity) {
        map = new HashMap<>(capacity);
        map.clear();
        head = null;
        tail = null;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            addToTail(key, node.value);
            return node.value;
        } else {
           return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {

            Node node = addToTail(key, value);
        } else {
            // cap more less
            if(map.size() == this.capacity) {
                map.remove(head.key);
                removeFirst();
            }
            Node node = addToTail(key, value);
        }
    }

    public void removeFirst() {
        if(head == null) {

        } else {
            head = head.next;
            if(head != null) {
                head.pre = null;
            }
        }
    }

    public Node addToTail(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            if(node == head && node == tail) {
                head = null;
                tail = null;
            } else if(node == head) {
                head = node.next;
                head.pre = null;
            } else if(node == tail) {
                tail = node.pre;
                tail.next = null;
            } else {
                if(node.pre != null) {
                    node.pre.next = node.next;
                }
                if(node.next != null) {
                    node.next.pre = node.pre;
                }
            }
            map.remove(node.key);
        }
        Node node = new Node();
        node.key = key;
        node.value = value;
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        map.put(key, node);
        return node;

    }

}
