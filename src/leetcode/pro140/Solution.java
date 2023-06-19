package leetcode.pro140;

import java.util.*;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word : wordDict) {
            set.add(word);
        }
        List<String> ans = new LinkedList<>();
        dfs(s, 0, "", ans, set);
        return ans;
    }

    public void dfs(String s, int index, String cur, List<String> ans, Set<String> wordDict) {
        if(index >= s.length()) {
            ans.add(new String(cur.substring(0, cur.length() - 1)));
            return;
        }
        for(int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if(wordDict.contains(sub)) {
                dfs(s, i, cur + (sub + " "), ans, wordDict);
            }
        }
    }

    public static void main(String[] argv) {
        new Solution().wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));
    }
}
