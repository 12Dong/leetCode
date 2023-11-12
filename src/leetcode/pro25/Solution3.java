package leetcode.pro25;

import leetcode.pro142.Solution5;

public class Solution3 {
    
      public static  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hh = new ListNode();
        hh.next = head;
        ListNode pre = hh;
        ListNode cur = head;
        int cnt = 1;
        while(cur != null) {
            cnt++;
            cur = cur.next;
            if(cur == null) {
                break;
            }
            if(cnt == k) {
                cur = reverse(pre, cur);
                cnt = 0;
                pre = cur;
            }
        }
        return hh.next;
    }

    public ListNode reverse(ListNode pre, ListNode last) {
          ListNode hh = new ListNode();
          hh.next = pre.next;
          ListNode p = pre;
          ListNode cur = pre.next;
          ListNode next = last.next;
          // 第一次改 next 有问题
          while(cur != next) {
              ListNode n = cur.next;
              cur.next = p;
              p = cur;
              cur = n;

          }
          pre.next.next = next;
          pre.next = p;
          return hh.next;

      }

      public static void main(String[] argv) {
          ListNode node1 = new ListNode(1);
          ListNode node2 = new ListNode(2);
          node1.next = node2;
          ListNode node3 = new ListNode(3);
          node2.next = node3;
          ListNode node4 = new ListNode(4);
          node3.next = node4;
          ListNode node5 = new ListNode(5);
          node4.next = node5;
          new Solution3().reverseKGroup(node1, 2);
      }

}
