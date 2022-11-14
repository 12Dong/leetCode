package pro121;

public class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int lowest = prices[0];
        int ans = 0;
        for(int i = 1; i < prices.length;i ++) {
            if(prices[i] < lowest) {
                lowest = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - lowest);
            }
        }
        return ans;
    }
}
