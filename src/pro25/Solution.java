package pro25;

import pro3.Soultion;

public class Solution {

    
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
     
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
          if(k == 1) {
              return head;
          }
          ListNode cur = head;
          ListNode process = head;
          ListNode lastProcess = null;
          ListNode pre = null;
          ListNode ans = null;
          int cnt = 0;
          while(cur != null) {
              if(cnt != 0 && cnt % k == 0) {
                  process = reverseK(process, k);
                  if(lastProcess != null) lastProcess.next = pre;
                  lastProcess = process;
                  process.next = cur;
                  process = cur;
              }
              pre = cur;
              cur = cur.next;
              cnt++;
              if(cnt == k - 1) {
                  ans = cur;
              }
          }
        if(cnt != 0 && cnt % k == 0) {
            process = reverseK(process, k);
            if(lastProcess != null) lastProcess.next = pre;
            lastProcess = process;
            process.next = cur;
            process = cur;
        }
          return ans;
    }

    public ListNode reverseK(ListNode head, int k) {
          ListNode cur = head;
          ListNode next = head.next;
          for(int i = 1; i < k;i ++) {
                ListNode nextNext = next.next;
                next.next = cur;
                cur = next;
                next = nextNext;
          }
          return head;
    }

    public static void main(String[] argv) {
          ListNode n5 = new ListNode(5);
          ListNode n4 = new ListNode(4, n5);
          ListNode n3 = new ListNode(3, n4);
          ListNode n2 = new ListNode(2, n3);
          ListNode n1 = new ListNode(1, n2);
          new Solution().reverseKGroup(n1, 2);

    }
}
