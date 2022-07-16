package pro148;

public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode listNode = middleNodeBefore(head);
        ListNode l2 = listNode.next;
        listNode.next = null;

        head = sortList(head);
        l2 = sortList(l2);
        return merge(head, l2);
    }

    public ListNode middleNodeBefore(ListNode head) {
        if(head == null) {
            return head;
        }
        if(head.next == null) {
            return head;
        }
        ListNode ans = null;
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null) {
            ans = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return ans;

    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return newHead.next;
    }
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
