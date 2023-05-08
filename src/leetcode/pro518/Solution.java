package leetcode.pro518;

public class Solution {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(j - coins[i] < 0) {
                    continue;
                }
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] argv) {
        new Solution().change(5, new int[]{1,2,5});
    }
}
