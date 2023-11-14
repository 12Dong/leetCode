package leetcode.pro139;

import java.util.*;

public class Solution3 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        Map<String, Boolean> map = new HashMap<>();
        for(String word : wordDict) {
            set.add(word);
        }
        return judge(s, set, map);
    }
    public boolean judge(String s, Set<String> set, Map<String, Boolean> map) {
        if(s.length() == 0) {
            return true;
        }
        boolean sign = false;
        for(int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            if(map.containsKey(prefix)) {
                if(map.get(prefix)) {
                    // 前缀已包含 判断后续字符串
                    String suffix = s.substring(i + 1);
                    if(map.containsKey(suffix)) {
                        if(map.get(suffix)) {
                            sign = sign | true;
                        } else {
                            sign = sign | false;
                        }
                    } else {
                        boolean result = judge(suffix, set, map);
                        map.put(suffix, result);
                        sign = sign | result;
                    }


                } else {
                    // 前缀不包含 向后遍历
                    continue;
                }
            } else {
                if(set.contains(prefix)) {
                    map.put(prefix, true);
                    // 前缀已包含 判断后续字符串
                    String suffix = s.substring(i + 1);
                    if(map.containsKey(suffix)) {
                        if(map.get(suffix)) {
                            sign = sign | true;
                        } else {
                            sign = sign | false;
                        }
                    } else {
                        boolean result = judge(suffix, set, map);
                        map.put(suffix, result);
                        sign = sign | result;
                    }
                } else {
                    map.put(prefix, false);
                }
            }
        }
        return sign;
    }

    /**
     * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
     * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
     */
}
