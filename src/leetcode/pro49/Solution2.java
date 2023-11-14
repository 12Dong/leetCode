package leetcode.pro49;

import java.util.*;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for(String str : strs) {
            TreeMap<Character, Integer> treeMap = new TreeMap<>();
            for(int i = 0; i < str.length(); i++) {
                treeMap.put(str.charAt(i), treeMap.getOrDefault(str.charAt(i), 0) + 1);
            }
            if(map.containsKey(treeMap)) {
                List<String> container = map.get(treeMap);
                container.add(str);
                map.put(treeMap, container);
            } else {
                List<String> container = new LinkedList<>();
                container.add(str);
                map.put(treeMap, container);
            }
        }
        return new LinkedList<>(map.values());
    }
}
