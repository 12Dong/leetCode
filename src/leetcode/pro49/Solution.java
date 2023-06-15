package leetcode.pro49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            TreeMap<Character, Integer> cntMap = new TreeMap<>();
            String cur = strs[i];
            for(int j = 0; j < cur.length(); j++) {
                char c = cur.charAt(j);
                cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
            }
            String key = "";
            for(Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
                key += (entry.getKey() + "_" + entry.getValue());
            }
            List<String> list = ans.getOrDefault(key, new LinkedList<>());
            list.add(cur);
            ans.put(key, list);
        }
        return new LinkedList<>(ans.values());
    }
}
