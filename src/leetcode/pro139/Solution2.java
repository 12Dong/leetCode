package leetcode.pro139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        result = false;
        Set<String> wordSet = new HashSet<>(wordDict);
        Set<String> vis = new HashSet<>();
        check(s, 0, wordSet, vis);
        return result;
    }

    boolean result = false;

    public boolean check(String s, int cur, Set<String> wordDict, Set<String> vis) {
        if(cur == s.length()) {
            result = true;
            return true;
        }
        for(int i = cur; i < s.length(); i++) {
            String curWord = s.substring(cur, i + 1);
            if(vis.contains(s.substring(0, i + 1))) {
                continue;
            }
            if(wordDict.contains(curWord)) {
                boolean tmp = check(s, i + 1, wordDict, vis);
                vis.add(s.substring(0, i + 1));
            } else {

            }

        }
        return false;
    }

    public static void main(String[] argv) {
        new Solution2().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"));
    }
}
