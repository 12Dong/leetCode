package leetcode.pro77;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(n, 1, k, new LinkedList<>(), ans);
        return ans;
    }

    public void dfs(int n, int cur, int k, List<Integer> list, List<List<Integer>> ans) {

        if(k == 0) {
            ans.add(new LinkedList<>(list));
            return;
        }

        if(cur > n) {
            return;
        }
        for(int i = cur; i <= n; i++) {
            list.add(i);
            dfs(n, i + 1, k - 1, list, ans);;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] argv) {
        new Solution().combine(4,2);
    }
}
