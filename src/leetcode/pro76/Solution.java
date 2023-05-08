package leetcode.pro76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> hs = new HashMap<>();
        Map<Character, Integer> ht = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }

        int len = Integer.MAX_VALUE;
        int cnt = 0;
        String ans = "";
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(ht.containsKey(s.charAt(i))) {
                int charCount = hs.getOrDefault(s.charAt(i), 0);
                charCount++;
                if(charCount <= ht.get(s.charAt(i))) {
                    cnt ++;
                }
                hs.put(s.charAt(i), charCount);
            }
            while(j < i) {
                if(!ht.containsKey(s.charAt(j))) {
                    j++;
                    continue;
                } else {
                    if(hs.get(s.charAt(j)) > ht.get(s.charAt(j))) {
                        int count = hs.get(s.charAt(j));
                        count--;
                        hs.put(s.charAt(j), count);
                        j++;
                        continue;
                    } else {
                        break;
                    }
                }
            }
            if(cnt == t.length()) {
                if(i - j + 1 < len) {
                    len = i - j + 1;
                    ans = s.substring(j, i+1);
                }
            }
        }
        return ans;
    }
}
