package leetcode.pro160;

public class Solution3 {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int stepa = 1;
        int stepb = 1;
        ListNode curA = headA;
        while(curA.next != null) {
            curA = curA.next;
            stepa++;
        }
        ListNode curB = headB;
        while(curB.next != null) {
            curB = curB.next;
            stepb++;
        }
        if(curA != curB) {
            return null;
        }
        if(stepa > stepb) {
            int tmp = stepa;
            stepa = stepb;
            stepb = tmp;
            ListNode tmpNode = headA;
            headA = headB;
            headB = tmpNode;
        }
        int diff = stepb - stepa;
        curA = headA;
        curB = headB;
        while(diff > 0) {
            diff--;
            curB = curB.next;
        }
        while(curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
