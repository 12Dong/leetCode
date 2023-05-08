package leetcode.pro395;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() < k) return 0;
        Map<Character, Integer> map = new HashMap<>();
        Boolean sign = true;
        for(int index = 0; index < s.length(); index++) {
            map.put(s.charAt(index), map.getOrDefault(s.charAt(index), 0) + 1);
        }
        for(Character c : map.keySet()) {
            if(map.get(c) < k) {
                sign = false;
            }
        }
        if(sign) {
            return s.length();
        }
        Integer ans = 0;
        for(Character c : map.keySet()) {
            if(map.get(c) < k) {
                for(String nextS : s.split("" + c)) {
                    ans = Integer.max(ans , longestSubstring(nextS, k));
                }
            }
        }
        return ans;
    }

}
