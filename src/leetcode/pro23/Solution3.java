package leetcode.pro23;

public class Solution3 {
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        for(int i = lists.length - 1; i >= 1; i--) {
            ListNode l1 = lists[0];
            ListNode l2 = lists[i];
            lists[0] = merge(l1, l2);
        }
        return lists[0];
    }

    public ListNode merge(ListNode l1, ListNode l2) {
          ListNode ans = new ListNode();
          ListNode tail = ans;
          while(l1 != null && l2 != null) {
              if(l1.val < l2.val) {
                  tail.next = l1;
                  l1 = l1.next;
              } else {
                  tail.next = l2;
                  l2 = l2.next;
              }
              tail = tail.next;
        }
        if(l1 != null) {
            tail.next = l1;
        }
        if(l2 != null) {
            tail.next = l2;
        }
        return ans.next;
    }
}
