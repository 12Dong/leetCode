package leetcode.pro1171;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> prefixSum = new HashMap<>();
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode cur = head;
        int sum = 0;
        while(cur != null) {
            sum += cur.val;
            prefixSum.put(sum, cur);
            cur = cur.next;
        }

        sum = 0;
        cur = pre;
        while(cur != null) {
            sum += cur.val;
            if(prefixSum.containsKey(sum)) {
                cur.next = prefixSum.get(sum).next;
            }
            cur = cur.next;

        }
        return pre.next;
    }
}
