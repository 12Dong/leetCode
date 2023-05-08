package leetcode.pro141;

public class Solution {

    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        if(head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != slow) {
            if(fast.next == null) {
                return false;
            }
            if(fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
    
       class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
}
