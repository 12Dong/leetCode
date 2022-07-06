package pro160;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 1;
        ListNode curA = headA;
        while(curA.next != null) {
            lenA++;
            curA = curA.next;
        }
        int lenB = 1;
        ListNode curB = headB;
        while(curB.next != null) {
            lenB++;
            curB = curB.next;
        }
        if(lenA > lenB) {
            ListNode tmp = headB;
            headB = headA;
            headA = tmp;
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
        }

        curA = headA;
        curB = headB;
        int dif = lenB - lenA;
        for(int step = 0; step < dif; step++) {
            curB = curB.next;
        }

        while(curA != curB) {
            curA = curA.next != null ? curA.next : null;
            curB = curB.next != null ? curB.next : null;
        }
        return curA;
    }
    
    
       public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
}
