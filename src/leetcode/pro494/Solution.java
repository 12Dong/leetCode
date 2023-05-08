package leetcode.pro494;

public class Solution {

    static int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][2001];
        dp[0][nums[0] + 1000] = dp[0][nums[0] + 1000] + 1;
        dp[0][1000 - nums[0]] = dp[0][1000 - nums[0]] + 1;
        for(int i = 1; i < nums.length; i ++) {
            for(int j = 0; j <= 2000; j++) {
                if(j + nums[i] <= 2000) {
                    dp[i][j] += dp[i-1][j + nums[i]];
                }
                if(j - nums[i] > 0) {
                    dp[i][j] += dp[i-1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target + 1000];
    }

    public static void main(String[] argv) {
        int ans = new Solution().findTargetSumWays(new int[]{1,1,1,1,1}, 3);
        System.out.println(ans);
    }
}
