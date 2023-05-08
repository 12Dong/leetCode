package leetcode.pro143;

import java.util.Stack;

public class Solution {
    
      static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        int length = 0;
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            length++;
        }
        cur = head;
        int cnt = 0;
        while(cur != null) {
            cur = cur.next;
            cnt++;
            if(cnt > length/2) {
                if(cur != null) stack.add(cur);
            }
        }
        cur = head;
        ListNode next = cur.next;
        while(!stack.isEmpty()) {
            ListNode p = stack.pop();
            cur.next = p;
            p.next = next;
            cur = next;
            next = cur.next;
        }
        if(cnt % 2 != 0) {
            cur.next = null;
        } else {
            cur.next.next = null;
        }
    }

    public static void main(String[] argv) {
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        new Solution().reorderList(l1);
    }
}
