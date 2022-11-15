package pro160;

public class Solution2 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        while(curA != null) {
            curA = curA.next;
            lenA++;
        }
        ListNode curB = headB;
        while(curB != null) {
            curB = curB.next;
            lenB++;
        }
        // headB 比 headA 长
        if(lenA > lenB) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
            int tmpL = lenA;
            lenA = lenB;
            lenB = tmpL;
        }
        int diff = lenB - lenA;
        curA = headA;
        curB = headB;
        int cnt = 0;
        while(cnt < diff) {
            curB = curB.next;
            cnt++;
        }

        while((curA != null && curB != null && !curA.equals(curB))) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;


    }


}
