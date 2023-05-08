package leetcode.prom322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if(amount == 0) return 0;
        if(amount < coins[0]) {
            return -1;
        }
        int length = amount;
        // dp i块钱 所需要的最少硬币
        int[] dp = new int[length + 1];
        int coinCnt = coins.length;
        Arrays.fill(dp, Integer.MAX_VALUE);
//        for(int i = 0; i < coinCnt; i++){
//            dp[coins[i]] = 1;
//        }
        dp[0] = 0;
        for(int i = 0; i <= length; i++){
            for(int j = 0; j < coinCnt; j++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    public static void main(String[] argv){
//        System.out.println(new Solution().coinChange(coins, amount));
    }

//    static int[] coins = new int[]{1, 2, 5};
//    static int[] coins = new int[]{1, Integer.MAX_VALUE};
//    static int[] coins = new int[]{2};
//    static int[] coins = new int[]{1};
//    static int[] coins = new int[]{2};
//    static int amount = 11;
//    static int amount = 2;
//    static int amount = 0;
//    static int amount = 2;
//    static int amount = 3;
}
