package leetcode.pro19;

public class Solution2 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hh = new ListNode();
        hh.next = head;
        ListNode fast = head;
        ListNode pre = hh;
        ListNode cur = head;
        while(n > 0) {
            n--;
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = cur.next;
        return hh.next;
    }
}
