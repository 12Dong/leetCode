package leetcode.pro123;

import java.util.Arrays;

public class Solution3 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        // dp[x][0] 第 0 次 什么也没有
        // dp[x][1] 第 1 次 持有
        // dp[x][2] 第 2 次 什么也没有
        // dp[x][3] 第 2 次 持有
        // dp[x][4] 第 3 次 什么也没有
        for(int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        int ans = 0;
        for(int i = 1; i < prices.length; i++) {
            for(int j = 0; j < 5; j++) {
                switch(j){
                    case 0:
                        dp[i][j] = dp[i - 1][j];
                        break;
                    case 1:
                        dp[i][j] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
                        break;
                    case 2:
                        dp[i][j] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
                        break;
                    case 3:
                        if(dp[i - 1][2] == Integer.MIN_VALUE) {

                        } else {
                            dp[i][j] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
                        }
                        break;
                    case 4:
                        if(dp[i - 1][3] == Integer.MIN_VALUE) {

                        } else{
                            dp[i][j] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
                        }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution3().maxProfit(new int[]{3,3,5,0,0,3,1,4});
    }
}
