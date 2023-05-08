package leetcode.pro139;

import java.util.*;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        Set<String> wordDictSet = new HashSet<>(wordDict);
        return check(s, 0, wordDictSet, map);
    }

    public static boolean check(String src, int cur, Set<String> wordDictSet, Map<String, Boolean> map) {
        for(int index = cur + 1; index <= src.length(); index++) {
            String curStr = src.substring(cur, index);
            if(map.containsKey(curStr)) {
                if(map.get(curStr)) {
                    boolean result = check(src, index, wordDictSet, map);
                    if(result) {
                        return result;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            } else {
                if(wordDictSet.contains(curStr)) {
                    map.put(curStr, true);
                    return true;
                } else {
                    if(curStr.length() == 1 || index == curStr.length()) {
                        map.put(curStr, false);
                        continue;
                    }
                    // 检查 curStr 是否可以又 wordDictSet中的元素组成
                    if(check(curStr, 0, wordDictSet, map)) {
                        map.put(curStr, true);
                        boolean result = check(src, index, wordDictSet, map);
                        if(result) {
                            return result;
                        } else {
                            continue;
                        }
                    } else {
                        map.put(curStr, false);
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] argv) {
        List<String> str = Arrays.asList("leet", "code");
        new Solution().wordBreak("leetcode", str);
    }
}
