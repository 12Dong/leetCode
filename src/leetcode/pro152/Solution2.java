package leetcode.pro152;

public class Solution2 {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                dp[0][0] = nums[i];
                dp[0][1] = nums[i];
                ans = Math.max(ans, dp[i][0]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] * nums[i]);
                ans = Math.max(ans, dp[i][0]);
            }
        }
        return ans;
    }
}
