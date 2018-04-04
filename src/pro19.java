public class pro19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode mov = head;
        for(int i=1;i<n+1 && mov!=null;i++) mov=mov.next;
        if(mov==null){
            head = head.next;
            return head;
        }
        ListNode ans = head;
        ListNode last = null;
        while(mov.next!=null){
            mov = mov.next;
            last = ans;
            ans = ans.next;
        }
        ans.next = ans.next.next;
        return head;
    }
}
