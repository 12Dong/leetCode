package leetcode.pro24;

public class Solution {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode start = new ListNode();
        start.next = head;
        ListNode pre = start;
        ListNode node1 = head;
        ListNode node2 = node1.next;
        while(node2 != null) {
            ListNode next = node2.next;
            pre.next = node2;
            node2.next = node1;
            node1.next = next;
            pre = node2;
            node1 = next;
            if(next != null) {
                node2 = next.next;
            } else {
                break;
            }
        }
        return start.next;
    }
}
