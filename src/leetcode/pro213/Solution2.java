package leetcode.pro213;

public class Solution2 {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        // 一定抢
        // dp[x][0] 抢了
        // dp[x][1] 非法状态
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for(int i = 1; i < nums.length; i++) {
            if(i == nums.length - 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            } else {
                dp[i][0] = dp[i - 1][1] + nums[i];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        int ans = Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
        // 一定不抢
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        ans = Math.max(ans, dp[nums.length - 1][0]);
        ans = Math.max(ans, dp[nums.length - 1][1]);
        return ans;
    }
}
