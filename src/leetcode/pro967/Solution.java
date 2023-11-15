package leetcode.pro967;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<String> ans = new LinkedList<>();
        for(int i = 1; i <= 9; i++) {
            Set<String> cur = new HashSet<>();
            Set<String> vis = new HashSet<>();
            dfs(n, i, k, "" + i, cur, vis);
            ans.addAll(cur);
        }
        int[] a = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            a[i] = Integer.valueOf(ans.get(i));
        }
        return a;
    }

    public void dfs(int n, int curV, int k, String curT, Set<String> ans,Set<String> vis) {
        if(curT.length() == n) {
            ans.add(curT);
            return;
        }
        int next = curV + k;
        if(next < 10) {
            if(!vis.contains(curT + ("" + next))) {
                vis.add(curT + ("" + next));
                dfs(n, next, k, curT + ("" + next), ans, vis);
            }
        }
        next = curV - k;
        if(next >= 0) {
            if(!vis.contains(curT + ("" + next))) {
                vis.add(curT + ("" + next));
                dfs(n, next, k, curT + ("" + next), ans, vis);
            }
        }
    }
}
/*
[135,131,246,242,202,357,353,313,468,464,424,420,579,575,535,531,686,646,642,797,757,753,868,864,979,975]

[131,135,202,242,246,313,353,357,420,424,464,468,531,535,575,579,642,646,686,753,757,797,864,868,975,979]
 */