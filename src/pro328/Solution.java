package pro328;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddCur = odd;
        ListNode evenCur = even;
        int index = 1;
        ListNode cur = head;
        while(cur != null) {
            if(index % 2 == 1) {
                oddCur.next = cur;
                oddCur = oddCur.next;
            } else {
                evenCur.next = cur;
                evenCur = evenCur.next;
            }
            index++;
            cur = cur.next;
        }
        oddCur.next = even.next;
        evenCur.next = null;
        return odd.next;

    }
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
