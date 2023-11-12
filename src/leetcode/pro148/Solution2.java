package leetcode.pro148;

public class Solution2 {
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public ListNode sortList(ListNode head) {
          int length = 0;
          if(head == null) {
              return head;
          }
          ListNode cur = head;
          do {
              cur = cur.next;
              length ++;
          } while(cur != null);
          if(length == 1) {
              return head;
          }
          if(length == 2) {
              ListNode head2 = head.next;
              head.next = null;
              head2.next = null;
              ListNode ans = merge(head, head2);
              return ans;
          }
          length = length / 2;
          ListNode pre = new ListNode();
          pre.next = head;
          ListNode head2 = head;
          while(length > 0) {
              length --;
              pre = pre.next;
              head2 = head2.next;
          }
          pre.next = null;
          head = sortList(head);
          head2 = sortList(head2);
          return merge(head, head2);



    }

    public ListNode merge(ListNode head1, ListNode head2) {
          ListNode hh = new ListNode();
          ListNode tail = hh;
          while(head1 != null && head2 != null) {
              if(head1.val < head2.val) {
                  tail.next = head1;
                  head1 = head1.next;
              } else {
                  tail.next = head2;
                  head2 = head2.next;
              }
              tail = tail.next;
          }
          if(head1 != null) {
              tail.next = head1;
          }
          if(head2 != null) {
              tail.next = head2;
          }
          return hh.next;
    }

    public static void main(String[] argv) {
          ListNode node4 = new ListNode(4);
          ListNode node2 = new ListNode(2);
          node4.next = node2;
          ListNode node1 = new ListNode(1);
          node2.next = node1;
          new Solution2().sortList(node4);
      }
}
