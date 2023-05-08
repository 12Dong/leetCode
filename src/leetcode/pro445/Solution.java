package leetcode.pro445;

import java.util.Stack;

public class Solution {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        for(ListNode cur = l1; cur != null; cur = cur.next) {
            stack1.add(cur.val);
        }
        Stack<Integer> stack2 = new Stack<>();
        for(ListNode cur = l2; cur != null; cur = cur.next) {
            stack2.add(cur.val);
        }

        ListNode cur = null;
        ListNode prev = null;
        int addition = 0;
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            Integer num1 = stack1.pop();
            Integer num2 = stack2.pop();

            prev = new ListNode((num1 + num2 + addition) % 10);
            addition = (num1 + num2 + addition) / 10;
            prev.next = cur;
            cur = prev;
        }

        while(!stack1.isEmpty()) {
            Integer num1 = stack1.pop();
            prev = new ListNode((num1 + addition) % 10);
            addition = (num1 + addition) / 10;
            prev.next = cur;
            cur = prev;
        }

        while(!stack2.isEmpty()) {
            Integer num2 = stack2.pop();
            prev = new ListNode((num2 + addition) % 10);
            addition = (num2 + addition) / 10;
            prev.next = cur;
            cur = prev;
        }

        while(addition != 0) {
            prev = new ListNode((addition) % 10);
            addition = (addition) / 10;
            prev.next = cur;
            cur = prev;
        }

        return cur;
    }
}
