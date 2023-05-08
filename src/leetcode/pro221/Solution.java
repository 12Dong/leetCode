package leetcode.pro221;

public class Solution {

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0) {
                        dp[i][j] = 1;
                        ans = Math.max(ans, dp[i][j]);
                        continue;

                    }

                    if(j == 0) {
                        dp[i][j] = 1;
                        ans = Math.max(ans, dp[i][j]);
                        continue;
                    }

                    int tmp = Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(tmp, dp[i-1][j-1]) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans * ans;
    }
}
