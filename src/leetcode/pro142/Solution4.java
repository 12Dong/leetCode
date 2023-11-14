package leetcode.pro142;

public class Solution4 {
    
      static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
    public ListNode detectCycle(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode slow = head;
        ListNode fast = pre;
        if(fast.next == null) {
            return null;
        }
        fast = fast.next;
        if(fast.next == null) {
            return null;
        }
        fast = fast.next;

        while(slow != fast) {
            slow = slow.next;
            if(fast.next == null) {
                return null;
            }
            fast = fast.next;
            if(fast.next == null) {
                return null;
            }
            fast = fast.next;
        }

        fast = pre;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] argv) {
        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode0 = new ListNode(0);
//        ListNode listNode4 = new ListNode(4);


        listNode.next = listNode2;
        listNode2.next = listNode;
//        listNode0.next = listNode4;
//        listNode4.next = listNode2;
        new Solution4().detectCycle(listNode);
    }
}
