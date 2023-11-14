package leetcode.pro5;

import java.util.Arrays;

public class Solution {
    public static  String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        int ans = 1;
        int startIndex = 0;
        int endIndex = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if(j - i == 1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    if(s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = 0;
                    } else {
                        if(i + 1 == j - 1) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        } else if(i + 1 < s.length() && j - 1 >= 0) {
                            if(dp[i + 1][j - 1] != 0) {
                                dp[i][j] = dp[i + 1][j - 1] + 2;
                            } else {
                                dp[i][j] = 0;
                            }
                        }
                    }
                }
                if(dp[i][j] > ans) {
                    ans = dp[i][j];
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    public static void main(String[] argv) {
        System.out.println(longestPalindrome("abbacabbac"));
    }
}
