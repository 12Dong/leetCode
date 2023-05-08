package leetcode.prom198;

public class Solution2 {

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int ans = dp[0][1];
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
            ans = Math.max(dp[i][0], ans);
            ans = Math.max(dp[i][1], ans);
        }
        return ans;
    }
}
