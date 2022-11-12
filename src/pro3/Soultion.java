package pro3;

import java.util.HashSet;
import java.util.Set;

public class Soultion {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Set set = new HashSet<>();
        int l = 0;
        int r = 0;
        int ans = 0;
        while(r < length) {
            if(set.contains(s.charAt(r))) {
                while(l <= r && set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            } else {
                set.add(s.charAt(r));
                ans = Math.max(ans, r - l + 1);
                r++;
            }
        }
        return ans;
    }

    public static void main(String[] argv) {}
}
