package swardoffer.pro48;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            if(!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
                ans = Math.max(ans, r - l);
            } else {
                while(!set.isEmpty() && set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(r));
                r++;
                ans = Math.max(ans, r - l );
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
    }
}
