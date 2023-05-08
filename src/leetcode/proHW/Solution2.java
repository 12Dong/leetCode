package leetcode.proHW;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//将两个升序数组合并为一个新的数组并返回。新数组满足数组头节点值不小于数组尾节点值，去掉数组头尾节点，
// 剩余数组依然满足数组头节点值不小于数组尾节点值，依次递推。
//        示例 1：
//        输入：l1 = [1,2,4], l2 = [1,3,5]
//        输出：[1，3，5，4，2，1]
//
//        示例 2：
//        输入：l1 = [5，10，15], l2 = [20，40]
//        输出：[10，20，40，15，5]
public class Solution2 {


    // head 10 20
    // tail  5 15 40
    // 10 20 40 15 5
    public static List<Integer> solution(int[] nums1, int[] nums2) {
        List<Integer> head = new ArrayList<>();
        List<Integer> tail = new ArrayList<>();
        int l1 = nums1.length;
        int l2 = nums2.length;
        int c1 = 0;
        int c2 = 0;
        while(c1 < l1 && c2 < l2) {
            // 小的数 先放 tail 再放 head
            int num = -1;
            if(nums1[c1] < nums2[c2]) {
                num = nums1[c1];
                c1++;
            } else {
                num = nums2[c2];
                c2++;
            }
            if(tail.size() == head.size()) {
                tail.add(num);
            } else {
                head.add(num);
            }
        }

        while(c1 < l1) {
            int num = nums1[c1];
            c1++;
            if(tail.size() == head.size()) {
                tail.add(num);
            } else {
                head.add(num);
            }
        }

        while(c2 < l2) {
            int num = nums2[c2];
            c2++;
            if(tail.size() == head.size()) {
                tail.add(num);
            } else {
                head.add(num);
            }
        }

        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < head.size(); i++) {
            ans.add(head.get(i));
        }
        for(int i = tail.size() - 1; i >=0; i--) {
            ans.add(tail.get(i));
        }
        for(int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
        return ans;
    }
    //        示例 1：
//        输入：l1 = [1,2,4], l2 = [1,3,5]
//        输出：[1，3，5，4，2，1]
//
//        示例 2：
//        输入：l1 = [5，10，15], l2 = [20，40]
//        输出：[10，20，40，15，5]

    public static void main(String[] argv) {
        int[] nums1 = new int[]{1,2,4};
        int[] nums2 = new int[]{1,3,5};
//        new Solution2().solution(nums1, nums2);
        nums1 = new int[]{5, 10, 15};
        nums2 = new int[]{20, 40};
        new Solution2().solution(nums1, nums2);
//        nums1 = new int[]{1,3,5,6};
//        nums2 = new int[]{1};
//        new Solution2().solution(nums1, nums2);
    }
}
