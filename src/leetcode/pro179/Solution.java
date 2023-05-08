package leetcode.pro179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = "" + nums[i];
        }
        Arrays.sort(strs, new Comparator<Object>() {
            @Override
            public int compare(Object o, Object t1) {
                String str1 = o.toString();
                String str2 = t1.toString();
                String new1 = str1 + str2;
                String new2 = str2 + str1;
                return new2.compareTo(new1);
            }
        });

        String ans = "";
        for(int i = 0; i < strs.length; i++) {
            ans += strs[i];
        }
        int start = 0;
        while(start < ans.length() - 1 && ans.charAt(start) == '0') {
            start++;
        }
        return ans.substring(start);
    }
}
