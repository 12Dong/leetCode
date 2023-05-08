package leetcode.pro123;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        long ans = Integer.MIN_VALUE;
        // 第 0 次交易 没股票
        long dp0 = 0;
        // 第 0 次交易 有股票
        long dp1 = -prices[0];
        // 第 1 次交易 没有股票
        long dp2 = Integer.MIN_VALUE;
        // 第 1 次交易 有股票
        long dp3 = Integer.MIN_VALUE;
        // 第 2 次交易 没有股票
        long dp4 = Integer.MIN_VALUE;
        for(int i = 1 ; i < n; i++) {
            long tdp0 = dp0;
            long tdp1 = Math.max(dp1, dp0 - prices[i]);
            long tdp2 = Math.max(dp2, dp1 + prices[i]);
            long tdp3 = Math.max(dp3, dp2 - prices[i]);
            long tdp4 = Math.max(dp4, dp3 + prices[i]);
            dp0 = tdp0;
            dp1 = tdp1;
            dp2 = tdp2;
            dp3 = tdp3;
            dp4 = tdp4;
            ans = Math.max(ans, dp4);
            ans = Math.max(ans, dp2);
        }
        return (int)Math.max(ans, 0);
    }

    public static void main(String[] argv){
        new Solution().maxProfit(prices);
    }

    public static int[] prices = new int[]{7,6,4,3,1};
//        public static int[] prices = new int[]{1,2,3,4,5};

}
