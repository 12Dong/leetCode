package prom122;

class Solution {
    public int maxProfit(int[] prices) {
        final int length = prices.length;
        int result = 0;
        for(int i = 0; i < length; i++){
            if(i - 1 >= 0 && prices[i] >= prices[i-1]){
                result += prices[i] - prices[i-1];
            }
        }
        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().maxProfit(prices));
    }

    static int[] prices = new int[]{7,1,5,3,6,4};
}
