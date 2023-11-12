package leetcode.pro142;

public class Solution5 {
    
      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && slow != null) {
            fast = fast.next;
            if(fast == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || slow == null) {
            return null;
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
