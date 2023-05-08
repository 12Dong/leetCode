package leetcode.pro714;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        //dp[i][0] 代表在 第i天持有股票的最大收益
        //dp[i][0] 代表在 第i天卖出股票时 获取的最大收益
        //dp[i][1] 代表在 第i天没有股票时 最大收益
        int result = 0;
        int[][] dp = new int[length][3];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0) {
                    if(i == 0) {
                        dp[i][j] = 0 - prices[i];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][1] - prices[i]);
                    }
                } else if(j == 1){
                    if(i == 0) {

                    } else {
                        dp[i][j] = dp[i-1][0] + prices[i] - fee;
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
        System.out.println(new Solution().maxProfit(prices, fee));
    }

    static int[] prices = new int[]{1, 3, 2,8, 4, 9};
    static int fee = 2;
}
