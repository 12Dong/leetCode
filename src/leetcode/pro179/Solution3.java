package leetcode.pro179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {
    public String largestNumber(int[] nums) {
        Integer[] ns = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            ns[i] = nums[i];
        }
        Arrays.sort(ns, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1) + String.valueOf(o2);
                String s2 = String.valueOf(o2) + String.valueOf(o1);

                return s2.compareTo(s1);
            }
        });
        String ans = "";
        for(int i = 0; i < ns.length; i++) {
            ans += ns[i];
        }
        for(int i = 0; i < ans.length(); i++) {
            if(ans.charAt(i) != '0') {
                return ans.substring(i);
            }
        }
        return "0";
    }

    public static void main(String[] argv) {
        new Solution3().largestNumber(new int[]{3,30,34,5,9});
    }
}
