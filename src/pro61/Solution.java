package pro61;

public class Solution {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode rotateRight(ListNode head, int k) {
          if(head == null) {
              return head;
          }
        ListNode move = head;
        ListNode source = head;
        ListNode newTail = head;
        int length = 0;
        while(move != null) {
            move = move.next;
            length ++;
        }
        k = k % length;
        if(k == 0) {
            return head;
        }
        move = head;
        for(int i = 0; i < k; i++) {
            move = move.next;
        }
        while(move.next != null) {
            move = move.next;
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        move.next = source;
        newTail.next = null;
        return newHead;
    }
}
