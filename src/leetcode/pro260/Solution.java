package leetcode.pro260;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] singleNumber(int[] nums) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        int sum = 0;
        for(int num : nums) {
            sum ^= num;
        }
        int val = 0;
        while((sum & 1) != 1) {
            sum = sum >> 1;
            val++;
        }
        for(int num : nums) {
            if(((num >> val) & 1) == 1) {
                list1.add(num);
            } else {
                list2.add(num);
            }
        }
        int num1 = once(list1);
        int num2 = once(list2);
        return new int[]{num1, num2};
    }

    public int once(List<Integer> nums) {
        int ans = 0;
        for(int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] argv) {
//        System.out.println(7 & 1);
  //      System.out.println(2 & 1);

        System.out.println(new Solution().singleNumber(new int[]{1,1,3,4}));
    }
}
