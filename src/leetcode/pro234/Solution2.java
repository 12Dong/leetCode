package leetcode.pro234;

public class Solution2 {
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public boolean isPalindrome(ListNode head) {
        int step = 0;
        ListNode cur = head;
        while(cur != null) {
            step++;
            cur = cur.next;
        }
        ListNode head2 = head;
        if(step % 2 == 0) {
            step = step / 2;
            while(step > 0) {
                step--;
                head2 = head2.next;
            }
        } else {
            step = step / 2 + 1;
            while(step > 0) {
                step--;
                head2 = head2.next;
            }
        }
        head2 = reverse(head2);
        ListNode cur1 = head;
        ListNode cur2 = head2;
        while(cur2 != null) {
            if(cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
          ListNode cur = head;
          ListNode pre = null;
          while(cur != null) {
              ListNode next = cur.next;
              cur.next = pre;
              pre = cur;
              cur = next;

          }
          return pre;
    }

    public static void main(String[] argv) {
          ListNode n1 = new ListNode(1);
          ListNode n2 = new ListNode(2);
          n1.next = n2;
//          ListNode n22 = new ListNode(2);
//          n2.next = n22;
//          ListNode n11 = new ListNode(1);
//          n22.next = n11;
          new Solution2().isPalindrome(n1);
      }
}
