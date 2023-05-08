package leetcode.pro438;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        List<Integer> ans = new LinkedList<>();
        Map<Character, Integer> cntMap = new HashMap<>();
        for(int i = 0; i < p.length(); i ++) {
            Character c = p.charAt(i);
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
            cnt++;
        }
        while(r < s.length()) {
            Character rC = s.charAt(r);
            if(!cntMap.containsKey(rC)) {
                r ++ ;
                while(l < r) {
                    Character lC = s.charAt(l);
                    if(cntMap.containsKey(lC)) {
                        cntMap.put(lC, cntMap.get(lC) + 1);
                        cnt++;
                    }
                    l++;
                }
            } else {
                if(cntMap.get(rC) == 0) {
                    Character lC = s.charAt(l);
                    if(cntMap.containsKey(lC)) {
                        cntMap.put(lC, cntMap.get(lC) + 1);
                        cnt++;
                    }
                    l++;
                } else {
                    cntMap.put(rC, cntMap.get(rC) - 1);
                    cnt--;
                    if(cnt == 0) {
                        ans.add(r - p.length() + 1);
                    }
                    r ++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().findAnagrams("cbaebabacd", "abc");
    }
}
