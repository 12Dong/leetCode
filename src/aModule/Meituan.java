package aModule;

public class Meituan {

    public static class Node {
        int value;
        Node pre;
        Node next;

        public Node() {

        }

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverse(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node cur = head;
        Node next = cur.next;
        while(cur != null) {
            cur.next = pre;
            cur.pre = next;
            pre = cur;
            cur = next;
            if(cur == null) {
                return pre;
            }
            next = cur.next;
        }

        return pre;
    }

    public static void main(String[] argv) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.pre = null;
        node1.next = node2;
        node2.pre = node1;
        node2.next = node3;
        node3.pre = node2;
        node3.next = null;

        Node hh = reverse(node1);
        while(hh != null) {
            System.out.println(hh.value);
            hh = hh.next;
        }
    }
}

