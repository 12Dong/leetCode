package leetcode.pro23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode node : lists) {
            if(node == null) continue;;
            pq.add(node);
        }
        ListNode ans = new ListNode(0);
        ListNode move = ans;
        while(!pq.isEmpty()) {
            ListNode cur = pq.poll();
            move.next = cur;
            move = move.next;
            if(cur.next != null) {
                pq.add(cur.next);
            }
        }
        return ans.next;
    }
    
       public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
