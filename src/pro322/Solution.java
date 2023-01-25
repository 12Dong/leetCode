package pro322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for(int cur = 1; cur <= amount; cur++) {
            int least = Integer.MAX_VALUE;
            for(int index = 0; index < coins.length; index++) {
                if(cur - coins[index] < 0) {
                    continue;
                } else {
                    if(dp[cur - coins[index]] == Integer.MIN_VALUE) {
                        continue;
                    }
                    least = Math.min(least, dp[cur - coins[index]]);
                }
            }

            if(least != Integer.MAX_VALUE) {
                dp[cur] = least + 1;
            }
        }

        if(dp[amount] != Integer.MIN_VALUE) {
            return dp[amount];
        } else {
            return - 1;
        }
    }
}
