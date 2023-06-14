package swardoffer.pro24;

public class Solution {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
          ListNode cur = head;
        ListNode next = cur.next;

        cur.next = null;
          while(next != null) {
              ListNode tmp = next.next;
              next.next = cur;
              cur = next;
              next = tmp;
          }
          return cur;
    }
}
