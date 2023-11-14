package leetcode.pro25;

public class Solution2 {
    
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
 
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) {
            return head;
        }

        ListNode pre = null;
        ListNode hh = null;
        ListNode h = head;
        ListNode t = null;
        int cnt = 1;
        ListNode cur = head;
        while(cur != null) {

            if(cnt == k) {
                ListNode next = cur.next;
                reverseGroup(pre, h, cur);
                if(hh == null) {
                    hh = new ListNode(1, cur);
                }
                pre = h;
                h = next;
                cnt = 0;

                cnt++;
                cur = h;
            } else {
                cnt++;
                cur = cur.next;
            }

        }
        return hh.next;
    }

    public static void reverseGroup(ListNode pre, ListNode head, ListNode tail) {
          ListNode pree = pre;
          ListNode cur = head;
          ListNode nextt = cur.next;
          // 循环 tail 不换
          while(cur != tail) {
            cur.next = pree;
            pree = cur;
            cur = nextt;
            nextt = nextt.next;
          }
          // tail 换
          ListNode next = cur.next;

          cur.next = pree;

          head.next = next;
          if(pre != null) {
              pre.next = cur;
          }

    }

    public static void main(String[] argv) {
          ListNode l3 = new ListNode(3, null);
          ListNode l2 = new ListNode(2, l3);
          ListNode l1 = new ListNode(1, l2);
          ListNode head = reverseKGroup(l1, 2);
          ListNode l4 = new ListNode(4);
    }
}
