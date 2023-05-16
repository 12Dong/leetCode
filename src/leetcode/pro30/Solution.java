package leetcode.pro30;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wordLength = words[0].length();
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i + wordLength * words.length <= s.length(); i++) {
            String str = s.substring(i, i + wordLength * words.length);
            if(check(str, map, wordLength)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean check(String s, Map<String, Integer> map, int wordLength) {
        Map<String, Integer> cntmap = new HashMap<>(map);
        int start = 0;
        while(start < s.length()) {
            String word = s.substring(start, start + wordLength);
            int cnt = cntmap.getOrDefault(word, 0);
            if(cnt == 0) {
                return false;
            } else {
                cntmap.put(word, cnt - 1);
                start += wordLength;
            }
        }
        return true;
    }
}