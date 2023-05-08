package leetcode.pro22;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        dfs("", n, n, ans);
        return ans;
    }

    public void dfs(String cur, int l, int r, List<String> ans) {
        if(l == 0 && r == 0) {
            String result = new String(cur);
            ans.add(result);
        }
        if(l > 0) {
            String next = cur + "(";
            dfs(next, l - 1, r, ans);
        }
        if(r > 0 && r > l) {
            String next = cur + ")";
            dfs(next, l, r - 1, ans);
        }

    }
}
