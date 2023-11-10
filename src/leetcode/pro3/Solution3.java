package leetcode.pro3;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int ans = 0;
        while(r < s.length()) {
            Character c = s.charAt(r);
            if(set.contains(c) ) {
                while(set.contains(c) && l < r ) {
                    set.remove(s.charAt(l));
                    l++;
                }
                //
                set.add(c);
                r++;
                ans = Math.max(ans, r - l);
            } else {
                set.add(c);
                r++;
                ans = Math.max(ans, r - l);
            }
        }
        return ans;
    }
}
