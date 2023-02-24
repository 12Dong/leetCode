package pro142;

public class Solution3 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode pre = new ListNode(100001);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        if (fast.next != null) {
            fast = fast.next;
        } else {
            return null;
        }
        if (fast.next != null) {
            fast = fast.next;
        } else {
            return null;
        }
        if (slow.next != null) {
            slow = slow.next;
        } else {
            return null;
        }
        while (fast != slow) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
            if (slow.next != null) {
                slow = slow.next;
            } else {
                return null;
            }
        }
        ListNode cur = pre;
        while (cur !=  slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
}
