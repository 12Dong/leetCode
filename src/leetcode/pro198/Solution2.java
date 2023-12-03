package leetcode.pro198;

public class Solution2 {
    public int rob(int[] nums) {
        int[][] dp = new int[2][2];
        // dp[0][0] 不打劫
        // dp[0][1] 打劫
        int ans = 0;
        if(nums.length == 1) {
            return nums[0];
        }
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                dp[0][0] = 0;
                dp[0][1] = nums[0];
            } else{
                dp[1][0] = Math.max(dp[0][1], dp[0][0]);
                dp[1][1] = dp[0][0] + nums[i];
                ans = Math.max(ans, dp[1][0]);
                ans = Math.max(ans, dp[1][1]);
                dp[0][0] = dp[1][0];
                dp[0][1] = dp[1][1];
            }
        }
        return ans;
    }
    public static void main(String[] argv) {
        new Solution2().rob(new int[]{2,1,1,2});
    }
}
