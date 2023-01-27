package pro19;

public class Solution {
    
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode move = head;
        ListNode delete = head;
        ListNode prev = new ListNode(2);
        prev.next = head;
        for(int i = 0; i < n; i++) {
            move = move.next;
        }
        if(move == null) {
            return head.next;
        }
        while(move != null) {
            move = move.next;
            delete = delete.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] argv) {
          ListNode l1 = new ListNode(1);
          ListNode l2 = new ListNode(2);
        l1.next = l2;
        new Solution().removeNthFromEnd(l1, 1);


    }
}
