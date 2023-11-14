package leetcode.pro2;

public class Solution {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rest = 0;
        ListNode hh = new ListNode();
        ListNode cur = hh;
        while(l1 != null && l2 != null) {
           int value = l1.val + l2.val + rest;
           rest = value / 10;
           value = value % 10;
           cur.next = new ListNode(value);
           cur = cur.next;
           l1 = l1.next;
           l2 = l2.next;
        }
        while(l1 != null) {
            int value = l1.val + rest;
            rest = value / 10;
            value = value % 10;
            cur.next = new ListNode(value);
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            int value = l2.val + rest;
            rest = value / 10;
            value = value % 10;
            cur.next = new ListNode(value);
            cur = cur.next;
            l2 = l2.next;
        }
        if(rest != 0) {
            cur.next = new ListNode(rest);
            cur = cur.next;
        }
        return hh.next;
    }
}
