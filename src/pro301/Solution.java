package pro301;

import java.util.*;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        int l = 0;
        int r = 0;
        maxL = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') l ++;
            if(c== ')') r++;
        }
        limit  = Math.max(l, r);
        dfs(0, "", s, ans, 0);
        List<String> rAns = new LinkedList<>();
        for(String str : ans) {
            if(str.length() == maxL) rAns.add(str);
        }
        return rAns;
    }

    static int maxL = 0;
    static int limit = 0;

    public void dfs(int index, String cur, String s, Set<String> ans, int score) {
        if(score < 0 || score > limit) {
            return;
        }
        if(index == s.length()) {
            if(cur.length() >= maxL && score == 0) {
                maxL = cur.length();
                ans.add(cur);
            }
            return;
        }
        char c =s.charAt(index);
        if(c == '(') {
            dfs(index + 1, cur + '(', s, ans, score + 1);
            dfs(index + 1, cur, s, ans, score);
        } else if(c == ')') {
            dfs(index + 1, cur + ')', s, ans, score - 1);
            dfs(index + 1, cur, s, ans, score);
        } else {
            dfs(index + 1, cur + c, s, ans, score);
        }
    }
}
