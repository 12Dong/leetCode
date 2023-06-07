package swardoffer.pro22;

public class Solution {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode ans = head;
        ListNode move = head;
        while(k > 0) {
            move = move.next;
            k--;
        }
        while(move == null) {
            move = move.next;
            ans = ans.next;
        }
        return ans;
    }
}
