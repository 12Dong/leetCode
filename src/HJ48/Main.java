package HJ48;

import java.util.Scanner;

import java.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int head = in.nextInt();
            Node first = new Node(-1);
            Node h = new Node(head, first, null);
            first.next = h;
            for(int i = 1; i < n; i++) {
                int val = in.nextInt();
                int pre = in.nextInt();
                Node cur = h;
                while(cur != null) {
                    if(cur.val == pre) {
                        Node c = new Node(val, cur, cur.next);
                        if(cur.next != null) {
                            cur.next.pre = c;
                        }
                        cur.next = c;

                    }
                    cur = cur.next;
                }
            }
            int remove = in.nextInt();
            Node cur = first;
            while(cur != null) {
                if(cur.val == remove) {
                    cur.pre.next = cur.next;
                }
                cur = cur.next;
            }
            cur = first;
            if(cur.next == null) {
                System.out.println("null");
                return;
            }
            while(cur != null) {
                System.out.println(cur.val);
                cur = cur.next;
            }

        }
    }

    public static class Node {
        Node pre;
        Node next;
        Integer val;

        Node(Integer val) {
            this.pre = null;
            this.next = null;
            this.val = val;
        }

        Node(Integer val, Node pre, Node next) {
            this.pre = pre;
            this.next = next;
            this.val = val;
        }
    }
}