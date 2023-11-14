package leetcode.pro386;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new LinkedList<>();
        for(int i = 1; i <= 9; i++) {
            if(i <= n) {
                dfs(i, n, ans);
            }
        }
        return ans;
    }

    public void dfs(int cur, int n, List<Integer> ans) {
        ans.add(cur);
        for(int i = 0; i <= 9; i++) {
            int next = cur * 10 + i;
            if(next <= n) {
                dfs(next, n, ans);
            }
        }
    }

    public static void main(String[] argv) {
        new Solution().lexicalOrder(13);
    }
}
