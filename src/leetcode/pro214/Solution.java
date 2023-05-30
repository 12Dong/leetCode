package leetcode.pro214;

import java.util.Arrays;

public class Solution {
    public String shortestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for(int r = 1; r < s.length(); r++) {
            for(int l = 0; l < r; l++) {
                if(s.charAt(l) == s.charAt(r)) {
                    if(r - l == 1) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l+1][r-1];
                    }

                }
            }
        }
        int location = 0;
        for(int i = 0; i < s.length(); i++)      {
            if(dp[0][i]) {
                location = i;
            }
        }

        String ans = "";
        for(int i = s.length() - 1; i > location; i--) {
            ans += s.charAt(i);
        }
        ans += s;
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().shortestPalindrome("aa"));
        System.out.println(new Solution().shortestPalindrome("aacecaaa"));
    }
}
