package pro121;

public class Solution {
    public int maxProfit(int[] prices) {
        int ans = Integer.MIN_VALUE;
        int min = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] <= min) {
                min = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - min);
            }
        }
        return ans <= 0 ? 0 : ans;
    }
}
