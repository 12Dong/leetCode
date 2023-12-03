package leetcode.pro121;

public class Solution4 {
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            ans = Math.max(ans, prices[i] - low);
        }
        return ans;

    }
}
