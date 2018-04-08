public class pro24 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode tmp;
        ListNode mov=node;
        ListNode tmp1;
        while(mov.next!=null && mov.next.next!=null){
            tmp = mov.next;
            mov.next = mov.next.next;
            tmp1 = mov.next.next;
            mov.next.next = tmp;
            mov.next.next.next=tmp1;
            mov = mov.next.next;
        }

        return node.next;
    }
}
