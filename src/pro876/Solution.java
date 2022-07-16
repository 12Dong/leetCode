package pro876;

public class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null) {
            return head;
        }
        if(head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
