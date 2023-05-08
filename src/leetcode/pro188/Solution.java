package leetcode.pro188;

public class Solution {

    public static int init = -1000;
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][3][k+1];
        for(int i = 0; i < prices.length;i ++) {
            for(int j = 0; j < 3; j++) {
                for(int t = 0; t <= k; t++) {
                    dp[i][j][t] = init;
                }
            }
        }
        // dp[x][0][k] 第 k 次 交易时 第x天 不买卖股票
        // dp[x][1][k] 第 k 次 交易时 第x天 卖股票
        // dp[x][2][k] 第 k 次 交易时 第x天 买股票
        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        dp[0][2][0] = - prices[0];
        int ans = 0;
        for(int t = 0; t <= k; t++) {
            for(int i = 1; i < prices.length; i++){
                for(int j = 0; j < i; j++) {
                    dp[i][0][t] = Math.max(dp[j][0][t], dp[j][1][t]);
                    dp[i][0][t] = Math.max(dp[i][0][t], dp[j][2][t]);

                    if(t - 1 >= 0 && dp[j][2][t-1] != init) {
                        dp[i][1][t] = Math.max(dp[i][1][t], dp[j][2][t - 1] + prices[i]);
                    }

                    if(dp[i][2][t] == init) {
                        dp[i][2][t] = Math.max(dp[j][0][t], dp[j][1][t]) - prices[i];
                    } else {
                        dp[i][2][t] = Math.max(dp[i][2][t], dp[j][0][t] - prices[i]);
                        dp[i][2][t] = Math.max(dp[i][2][t], dp[j][1][t] - prices[i]);
                    }

                    ans = Math.max(ans, dp[i][0][t]);
                    ans = Math.max(ans, dp[i][1][t]);
                    ans = Math.max(ans, dp[i][2][t]);

                }
            }
        }
        return ans;
    }


    public static void main(String[] argv) {
        new Solution().maxProfit(2, new int[]{6,1,3,2,4,7});
    }
}
