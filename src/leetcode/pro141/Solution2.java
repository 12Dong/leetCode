package leetcode.pro141;

public class Solution2 {
      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && slow != null) {
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;

            } else {
                return false;
            }
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}
