package pro142;

public class Solution2 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode detectCycle(ListNode head) {
        ListNode hh = new ListNode(Integer.MAX_VALUE);
        hh.next = head;
        ListNode fast = hh;
        ListNode slow = hh;
         do {
            if(fast.next == null) {
                return null;
            }
            fast = fast.next;
            if(fast.next == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            } while(fast != slow);

        ListNode start = new ListNode(1);
        start.next = hh;
        ListNode again = hh;
        do  {
            start = start.next;
            again = again.next;
            slow = slow.next;
        }while (again != slow);
        return again;
    }

    public static void main(String[] argv) {
          ListNode head = new ListNode(3);
          ListNode node2 = new ListNode(2);
          ListNode node0 = new ListNode(0);
          ListNode node4 = new ListNode(4);
          head.next = node2;
          node2.next = node0;
          node0.next = node4;
          node4.next = node2;
          System.out.println(new Solution2().detectCycle(head));
    }
}
