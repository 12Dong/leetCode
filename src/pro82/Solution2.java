package pro82;

public class Solution2 {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) {
            return head;
        }
        ListNode hh = new ListNode(-101);
        hh.next = head;
        ListNode ans = new ListNode(-102);
        ans.next = hh;
        ListNode prev = hh;
        ListNode cur = head;
        ListNode next = head.next;
        while(cur != null) {
            if(prev.val == cur.val) {
                prev = cur;
                cur = cur.next;
                if(cur != null) {
                    next = cur.next;
                }
                continue;
            }

            if(next != null && next.val == cur.val) {
                prev = cur;
                cur = cur.next;
                if(cur != null) {
                    next = cur.next;
                }
                continue;
            }

            hh.next = cur;
            hh = hh.next;
            prev = cur;
            cur = cur.next;
            if(cur != null) {
                next = cur.next;
            }
        }
        hh.next = cur;
        return ans.next.next;
    }
}
