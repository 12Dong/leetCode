package leetcode.pro206;

public class Solution3 {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    
    public ListNode reverseList(ListNode head) {
          ListNode hh = new ListNode();
          hh.next = head;
          ListNode cur = head;
          ListNode pre = null;
          while(cur != null) {
              ListNode next = cur.next;
              cur.next = pre;
              pre = cur;
              cur = next;
          }
          hh.next.next = null;
          return pre;
    }
}
