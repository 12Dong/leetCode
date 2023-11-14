package leetcode.pro206;

public class Solution2 {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode before = null;
        ListNode next = cur.next;
        while(cur != null) {
            cur.next = before;
            before = cur;
            cur = next;
            if(next != null) {
                next = next.next;
            }
        }
        return before;
    }

}
