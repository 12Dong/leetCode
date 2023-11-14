package leetcode.pro24;

public class Solutiion2 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode hh = new ListNode();
        hh.next = head;
        ListNode preSlow = hh;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null) {
            ListNode next = fast.next;
            preSlow.next = fast;
            fast.next = slow;
            slow.next = next;
            preSlow = slow;
            slow = next;
            if(slow == null) {
                break;
            } else {
                fast = slow.next;
            }
        }
        return hh.next;
    }
}
