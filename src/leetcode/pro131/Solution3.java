package leetcode.pro131;

import java.util.LinkedList;
import java.util.List;

public class Solution3 {
    static int[][] dp;
    public List<List<String>> partition(String s) {
        dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for(int i = s.length() - 1; i >= 0; i --) {
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(i + 1 == j) {
                        dp[i][j] = 2;
                    } else {
                        if(dp[i + 1][j - 1] != 0) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        }
                    }
                }
            }
        }
        List<List<String>> ans = new LinkedList<>();
        dfs(ans, s, 0, 0, new LinkedList<>());
        return ans;
    }

    public void dfs(List<List<String>> ans, String s, int start, int index, List<String> cur) {
        if(start == s.length()) {
            ans.add(new LinkedList<>(cur));
        }
        if(index == s.length()) {
            return;
        }
        if(dp[start][index] != 0) {
            cur.add(s.substring(start, index + 1));
            dfs(ans, s, index + 1, index + 1, cur);
            cur.remove(cur.size() - 1);
        }
        dfs(ans, s, start, index + 1, cur);
    }
}
