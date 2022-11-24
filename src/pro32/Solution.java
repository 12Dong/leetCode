package pro32;

public class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int ans = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == '(') {
                continue;
            } else {
                if(i > 0 && s.charAt(i - 1) == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i-2] + 2 : 2;

                } else if(i - dp[i-1] -1 > 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = dp[i - dp[i-1] - 2] + dp[i-1] + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
