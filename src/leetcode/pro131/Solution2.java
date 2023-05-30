package leetcode.pro131;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for(int r = 1; r < s.length(); r++) {
            for(int l = 0; l < r; l++) {
                if(s.charAt(l) == s.charAt(r)) {
                    if(r -l == 1) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                }
            }
        }
        List<List<String>> ans = new LinkedList<>();
        dfs(s, dp, 0, new LinkedList<>(), ans);
        return ans;
    }

    public void dfs(String s, boolean[][] dp, int curL, List<String> curS, List<List<String>> ans) {
        if(curL >= s.length()) {
            ans.add(new LinkedList<String>(curS));
            return;
        }
        for(int i = curL; i < s.length(); i++) {
            if(dp[curL][i]) {
                curS.add(s.substring(curL,  i + 1));
                dfs(s, dp, i + 1, curS, ans);
                curS.remove(curS.size() - 1);
            }
        }
    }
}
