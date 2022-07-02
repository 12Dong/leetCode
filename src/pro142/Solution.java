package pro142;

public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }

            ListNode fast = head;
            int fIndex = 0;
            ListNode slow = head;
            int sIndex = 0;

            do  {
                if (fast.next == null) {
                    return null;
                }
                if (fast.next.next == null) {
                    return null;
                }
                fast = fast.next.next;
                slow = slow.next;
            } while((fast != slow));
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }

}

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
}
