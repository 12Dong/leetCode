package problem2;

/**
 * @Author: qiqu
 */
public class Main {

    /**
     * Definition for singly-linked list.
     *
     **/
     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode start = new ListNode(0);
            ListNode result = start;
            int currentVal = 0;
            int step = 0;
            while(l1 != null && l2 !=null){
                int val1 = l1.val;
                int val2 = l2.val;
                currentVal = val1 + val2 + step;
                step = currentVal / 10;
                result.next = new ListNode(currentVal%10);
                l1 = l1.next;
                l2 = l2.next;
                result = result.next;
            }
            while(l1 != null) {
                int val1 = l1.val;
                currentVal = val1 + step;
                step = currentVal / 10;
                result.next = new ListNode(currentVal%10);
                l1 = l1.next;
                result = result.next;
            }

            while(l2 != null) {
                int val2 = l2.val;
                currentVal = val2 + step;
                step = currentVal / 10;
                result.next = new ListNode(currentVal%10);
                l2 = l2.next;
                result = result.next;
            }
            if(step == 1){
                result.next = new ListNode(1);
            }
            return start.next;
        }
    }

}
