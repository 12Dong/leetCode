package leetcode.pro322;

import java.util.Arrays;

public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int j = 0; j < coins.length; j++) {
            for(int i = 0; i <= amount; i++) {
                if(i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int)dp[amount];
        }
    }

    public static void main(String[] argv) {
        new Solution2().coinChange(new int[]{2}, 3);
    }
}
