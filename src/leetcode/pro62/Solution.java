package leetcode.pro62;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    dp[1][j] = 1;
                } else {
                    if(j == 0) {
                        dp[1][j] = dp[0][j];
                    } else {
                        dp[1][j] = dp[0][j] + dp[1][j-1];
                    }
                }
                dp[0] = dp[1];
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] argv) {
        new Solution().uniquePaths(3, 7);
    }
}
