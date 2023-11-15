package leetcode.pro22;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        dfs(ans, n, 0, 0, "");
        return ans;
    }

    public void dfs(List<String> ans, int n, int l, int r, String cur) {
        if(r == n) {
            ans.add(new String(cur));
            return;
        }
        if(l < n) {
            String next = cur + "(";
            dfs(ans, n, l + 1, r, next);
        }
        if(r < l) {
            String next = cur + ")";
            dfs(ans, n, l, r + 1, next);
        }
    }
}
