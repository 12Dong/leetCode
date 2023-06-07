package leetcode.pro83;

public class Solution {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode hh = new ListNode(-101);
        hh.next = head;
        ListNode pre = hh;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            while(next != null && next.val == cur.val) {
                next = next.next;
            }
            pre.next = cur;
            pre = cur;
            cur.next = next;
            cur = next;
        }

        return hh.next;
    }
}
