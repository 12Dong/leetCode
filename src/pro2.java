import java.util.List;

public class pro2 {
    static class Solution {
        static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(0);
            ListNode node = root;
            int add = 0;
            while (l1 != null && l2 != null) {
                node.val = (l1.val + l2.val + add) % 10;
                add = (l1.val + l2.val + add) / 10;
                l1 = l1.next;
                l2 = l2.next;
                if (!(l1 == null && l2 == null && add == 0)){
                    node.next = new ListNode(0);
                    node = node.next;
                }
            }
            while (l1 != null) {
                node.val = (l1.val + add) % 10;
                add = (l1.val + add) / 10;
                l1 = l1.next;
                if (!(l1 == null && add == 0)) {
                    node.next = new ListNode(0);
                    node = node.next;
                }
            }
            while (l2 != null) {
                node.val = (l2.val + add) % 10;
                add = (l2.val + add) / 10;
                l2 = l2.next;
                if (!(l2 == null && add == 0)){
                    node.next = new ListNode(0);
                    node = node.next;
                }
            }
            if(add!=0){
                node.val=add;
            }
            return root;
        }
    }
    static void display(ListNode listNode){

        while(listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }
    public static void main(String argv[]){
        ListNode listNode1 = new ListNode(5);
        ListNode listNodeOne = listNode1;
        listNode1.next = new ListNode(2);
        listNode1 = listNode1.next;
        listNode1.next = new ListNode(5);
        ListNode listNode2 = new ListNode(5);
        ListNode listNodeTwo = listNode2;
        listNode2.next = new ListNode(2);
        listNode2 = listNode2.next;
        listNode2.next = new ListNode(7);
        listNode2 = listNode2.next;
        listNode2.next = new ListNode(4);
        pro2 pro = new pro2();
        pro2.display(listNodeOne);
        pro2.display(listNodeTwo);
        ListNode ans = pro2.Solution.addTwoNumbers(listNodeOne,listNodeTwo);
        pro2.display(ans);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}