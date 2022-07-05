package pro131;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int r = 0; r < len; r++) {
            for(int l = 0; l <= r; l++) {
                if(s.charAt(r) == s.charAt(l)) {
                    if(r - l <= 2) {
                        dp[l][r] = r - l + 1;
                    } else if(dp[l+1][r-1] >= 1) {
                        dp[l][r] = dp[l+1][r-1] + 2;
                    }
                }
            }
        }
        List<List<String>> ans = new LinkedList<>();
        dfs(0, ans, new LinkedList<>(), s, dp);
        return ans;
    }

    public static void dfs(int right, List<List<String>> ans, List<String> having, String s, int[][] dp) {
        if(right == s.length()) {
            ans.add(having);
            return;
        }
        for(int next = right; next < s.length(); next++) {
            if(dp[right][next] != 0) {
                List<String> cur = new LinkedList<>(having);
                cur.add(s.substring(right, next + 1));
                dfs(next + 1, ans, cur, s, dp);
            }
        }
    }

    public static void main(String[] argv) {
        new Solution().partition("a");
    }
}
