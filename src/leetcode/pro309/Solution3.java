package leetcode.pro309;

import java.util.Arrays;

public class Solution3 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        // dp[x][0] 起始状态 没有股票 不是冷冻期
        // dp[x][1] 手上有股票
        // dp[x][2] 没有股票 是冷冻期
        dp[0][1] = - prices[0];
        int ans = 0;
        for(int i = 1; i < prices.length; i++) {
            for(int j = 0; j < 3; j++) {
                if(j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][0], dp[i - 1][2]);
                } else if(j == 1) {
                    dp[i][j] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                } else {
                    dp[i][j] = dp[i - 1][1] + prices[i];
                }
                ans = Math.max(ans, dp[i][j]);
            }

        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution3().maxProfit(new int[]{1,2,4});
    }
}
