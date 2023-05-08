package leetcode.pro309;

public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        //dp[i][0] 代表在 第i天持有股票的最大收益
        //dp[i][0] 代表在 第i天卖出股票时 获取的最大收益
        //dp[i][1] 代表在 第i天没有股票 且 不是冷冻期的最大收益
        int result = 0;
        int[][] dp = new int[length][3];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0) {
                    if(i == 0) {
                        dp[i][j] = 0 - prices[i];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                    }
                } else if(j == 1){
                    if(i == 0) {

                    } else {
                        dp[i][j] = dp[i-1][0] + prices[i];
                    }
                } else if(j == 2){
                    if(i == 0){
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][2], dp[i-1][1]);
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().maxProfit(prices));
    }

    static int[] prices = new int[]{1, 2, 3, 0, 2};
}
