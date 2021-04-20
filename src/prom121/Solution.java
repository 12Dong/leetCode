package prom121;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            result = Math.max(prices[i] - min, result);
            min = Math.min(prices[i], min);
        }
        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().maxProfit(prices));
    }

//    static int[] prices = new int[]{7,1,5,3,6,4};
    static int[] prices = new int[]{7,6,4,3,1};
}
