package leetcode.pro122;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        // dp[x][0] 第x天 不买卖股票
        // dp[x][1] 第x天 卖股票
        // dp[x][2] 第x天 买股票
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = - prices[0];
        int ans = 0;
        for(int i = 1; i < prices.length; i++) {
            for(int j = 0; j < i; j++) {
                dp[i][0] = Math.max(dp[j][0], dp[j][1]);
                dp[i][0] = Math.max(dp[i][0], dp[j][2]);

                dp[i][1] = Math.max(dp[i][1], dp[j][2] + prices[i]);

                if(dp[i][2] == 0) {
                    dp[i][2] = Math.max(dp[j][0], dp[j][1]) - prices[i];
                } else {
                    dp[i][2] = Math.max(dp[i][2], dp[j][0] - prices[i]);
                    dp[i][2] = Math.max(dp[i][2], dp[j][1] - prices[i]);
                }

            }
            ans = Math.max(ans, dp[i][0]);
            ans = Math.max(ans, dp[i][1]);
            ans = Math.max(ans, dp[i][2]);
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution2().maxProfit(new int[]{1,2,3,4,5});
    }
}
