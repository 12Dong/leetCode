package leetcode.pro53;

public class Solution3 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(i != 0) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            } else {
                dp[i] = nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
