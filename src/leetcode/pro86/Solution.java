package leetcode.pro86;

public class Solution {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode smallHead = new ListNode(-1);
        ListNode largeHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode largeTail = largeHead;
        while(cur != null) {
            if(cur.val < x) {
                smallTail.next = cur;
                smallTail = smallTail.next;
            } else {
                largeTail.next = cur;
                largeTail = largeTail.next;
            }
            cur = cur.next;
        }
        smallTail.next = largeHead.next;
        largeTail.next = null;
        return smallHead.next;
    }
}
