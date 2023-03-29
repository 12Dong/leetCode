package pro234;

import java.util.Stack;

public class Solution {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode middle = middleNode(head);
        ListNode head2 = reverse(middle);
        while(head2 != null) {
            if(head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public ListNode middleNode(ListNode head) {
          ListNode slow = new ListNode(-1);
          slow.next = head;
          ListNode fast = new ListNode(-1);
          fast.next = head;
            while(fast != null && fast.next != null) {
              fast = fast.next;

              if(fast != null) {
                  fast = fast.next;
              }
              slow = slow.next;
          }
          return slow.next;
    }

    public ListNode reverse(ListNode listNode) {
          ListNode pre = null;
          ListNode cur = listNode;
          ListNode next = listNode.next;
          while(next != null) {
              cur.next = pre;
              pre = cur;
              cur = next;
              next = cur.next;
          }
          cur.next = pre;
          return cur;
    }
}
