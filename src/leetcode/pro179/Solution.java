package leetcode.pro179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = "" + nums[i];
        }
        Arrays.sort(strs);

        String ans = "";
        for(int i = strs.length -1; i >= 0 ; i--) {
            ans += strs[i];
        }
        int start = 0;
        while(start < ans.length() - 1 && ans.charAt(start) == '0') {
            start++;
        }
        return ans.substring(start);
    }

    public static void main(String[] argv) {
        System.out.println("3".compareTo("30"));
    }
}
