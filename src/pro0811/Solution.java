package pro0811;

public class Solution {
    public int waysToChange(int n) {
        int mod = 1000000007;
        int[] coins = new int[]{1,5,10,25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int j = 0; j < coins.length; j++) {
        for(int i = 1; i <= n; i++) {
                if(i - coins[j] >= 0) {
                    dp[i] = (dp[i] + dp[i - coins[j]]) % mod;
                }
            }
        }
        return dp[n];
    }
}
