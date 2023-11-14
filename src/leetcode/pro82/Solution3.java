package leetcode.pro82;

public class Solution3 {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode hh = new ListNode();
        hh.next = head;
        ListNode cur = head;
        ListNode pre = hh;
        ListNode pp = hh;
        int value = cur.val;
        int cnt = 0;
        while(cur != null) {
            if(cur.val == value) {
                cnt++;
                pp = cur;
                cur = cur.next;
            } else {
                if(cnt == 1) {
                    // 链表不变 状态重置
                    cnt = 1;
                    pre = pp;
                    value = cur.val;

                    //
                    pp = cur;
                    cur = cur.next;
                } else {
                    // 链表删除 状态重置
                    deleteNode(pre, cur);
                    cnt = 1;

                    //pre 不变
                    value = cur.val;
                    pp = cur;
                    cur = cur.next;
                }
            }
        }
        if(cnt == 1) {

        } else {
            deleteNode(pre, cur);
        }
        return hh.next;
    }

    public void deleteNode(ListNode pre, ListNode next) {
        pre.next = next;
    }
}
