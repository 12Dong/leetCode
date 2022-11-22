package pro92;

public class Solution {
    
     public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
    public ListNode reverseBetween(ListNode head, int left, int right) {
         ListNode headBefore = new ListNode();
         headBefore.next = head;
        int cnt = 1;
        ListNode cur = head;
        ListNode before = headBefore;
        for(;cnt < left; cnt++) {
            before = cur;
            cur = cur.next;

        }
        ListNode next = cur.next;
        for(; cnt < right; cnt++) {
            ListNode nextNext = next.next;
            next.next = cur;
            cur = next;
            next = nextNext;
        }
        ListNode start = before.next;
        before.next = cur;
        start.next = next;

        return headBefore.next;
    }
}
