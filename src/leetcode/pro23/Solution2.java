package leetcode.pro23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode head = new ListNode();
        ListNode next = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode node : lists) {
            if(node == null) continue;
            queue.add(node);
        }
        while(!queue.isEmpty()) {
            ListNode cur = queue.poll();
            next.next = cur;
            next = next.next;
            if(cur.next != null) queue.add(cur.next);
        }

        return head.next;

    }
}
