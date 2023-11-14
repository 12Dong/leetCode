package leetcode.pro3;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int l = 0;
        int r = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int ans = 1;
        while(l < r && r < s.length()) {
            Character c = s.charAt(r);
            if(set.contains(c)) {
                while(l < r && set.contains(c)) {
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(c);
                r++;
                ans = Math.max(set.size(), ans);
            } else {
                set.add(c);
                r++;
                ans = Math.max(set.size(), ans);
            }
        }
        return ans;
    }
}
