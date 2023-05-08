package leetcode.pro206;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode last = null;
        while(cur.next != null) {
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        cur.next = last;
        return cur;
    }
    
       public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
