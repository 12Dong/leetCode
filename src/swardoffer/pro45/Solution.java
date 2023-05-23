package swardoffer.pro45;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < strs.length; i++) {
            strs[i] = "" + nums[i];;
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        String ans = "";
        for(int i = 0; i < strs.length; i++) {
            ans += strs[i];
        }
        return ans;
    }
}
