package aModule;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionDD {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

    public static Node sort(List<Node> nodeList) {
        Node head = new Node(-1);
        Node cur = head;
        while(!nodeList.isEmpty()) {
            Node next = findSmall(nodeList);
            nodeList.remove(next);
            if(next.next != null) {
                nodeList.add(next.next);
            }
            cur.next = next;
            cur = cur.next;
            cur.next = null;
        }

        return head.next;
    }

    public static Node findSmall(List<Node> nodeList) {
        Node ans = null;
        for(Node node : nodeList) {
            if(ans == null) {
                ans = node;
            } else {
                if(node.value < ans.value) {
                    ans = node;
                }
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node3;
        node2.next = node4;
        node5.next = node6;

        List<Node> list = new LinkedList<>();
        list.add(node1);
        list.add(node2);
        list.add(node5);
        Node ans = sort(list);
        int i =  1;
    }
}
