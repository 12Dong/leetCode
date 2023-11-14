package leetcode.pro146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache4 {

    class LRUCache {

        public class Node {
            Node pre;
            Node next;
            int key;
            int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        // 用的最少
        public Node head = null;
        // 最近用过
        public Node tail = null;
        public Map<Integer, Node> map = null;
        int capacity = 0;

        public LRUCache(int capacity) {
            this.map = new HashMap(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            if(map.containsKey(key)) {
                Node node = map.get(key);
                deleteNode(key);
                // 插入到 tail 后面
                Node newNode = new Node(node.key, node.value);
                insert(newNode);
                return newNode.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                // 删除老节点 更新新节点
                Node delete = map.get(key);
                deleteNode(delete.key);
                Node node = new Node(key, value);
                insert(node);

            } else {
                // 不超过上限 put map 更新 tail
                if(map.size() < capacity) {
                    Node node = new Node(key, value);
                    insert(node);
                } else {
                    // 删除老节点 更新新节点
                    Node delete = head;
                    deleteNode(delete.key);
                    Node node = new Node(key, value);
                    insert(node);
                }
            }
        }

        public void deleteNode(int key) {
            Node delete = map.get(key);
            if(delete.pre != null) {
                delete.pre.next = delete.next;
            }
            if(delete.next != null) {
                delete.next.pre = delete.pre;
            }
            if(delete == head) {
                head = head.next;
                if(head != null) {
                    head.pre = null;
                }
            }
            if(delete == tail) {
                tail = tail.pre;
                if(tail != null) {
                    tail.next = null;
                }
            }
            map.remove(key);
        }

        public void insert(Node node) {
            if(head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.pre = tail;
                tail = tail.next;
            }
            map.put(node.key, node);
        }
    }
}
