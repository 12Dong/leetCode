package leetcode.pro213;

public class Solution {

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];

        // 第一间 一定偷
        dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
           if( i == 1) {
               dp[1][0] = dp[0][1];
               dp[1][1] = dp[0][1];
           } else if(i == nums.length - 1) {
               dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
               dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
           } else{
                   dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
                   dp[i][1] = Math.max(dp[i-1][0] + nums[i], dp[i-1][1]);
           }
        }
        int ans = Math.max(dp[nums.length - 1][0],  dp[nums.length - 1][1]);

        // 第一间 一定没偷
        dp = new int[nums.length][2];
        for(int i = 1; i < nums.length; i++) {
            if( i == 1) {
                dp[1][0] = 0;
                dp[1][1] = nums[i];
            } else if(i == nums.length - 1) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
                dp[i][1] = Math.max(dp[i-1][0] + nums[i], dp[i-1][1]);
            } else{
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
                dp[i][1] = Math.max(dp[i-1][0] + nums[i], dp[i-1][1]);
            }
        }
        ans = Math.max(ans,  dp[nums.length - 1][1]);
        ans = Math.max(ans, dp[nums.length - 1][0]);
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().rob(new int[]{9, 1, 1, 9}));
    }
}
