package leetcode.pro121;

public class Solution3 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < prices.length; i++) {
            if(i == 0) {
                continue;
            } else {
                if(sum + prices[i] - prices[i - 1] < 0) {
                    sum = 0;
                } else {
                    sum = sum + prices[i] - prices[i - 1];
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
