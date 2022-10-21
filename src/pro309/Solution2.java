package pro309;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        // dp[x][0] 在 x 天 持有股票的最大收益
        // x
        // dp[x][1] 在 x 天 没有股票 且不处于冷静期
        // y
        // dp[x][2] 在 x 天 没有买股票 处于冷静期
        // z

        int x =  - prices[0];
        int y = 0;
        int z = 0;
        for(int i = 1; i < length; i ++ ) {
            int tmpx = Math.max(x, y - prices[i]);
            int tmpy = Math.max(y, z);
            int tmpz = x + prices[i];
            x = tmpx;
            y = tmpy;
            z = tmpz;
        }
        int ans = Math.max(x, y);
        ans = Math.max(ans, z);
        return ans;
    }
}
