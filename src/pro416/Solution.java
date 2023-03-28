package pro416;

public class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1) {
            return false;
        }
        int[][] dp = new int[nums.length][sum + 1];
        dp[0][0] = 1;
        dp[0][nums[0]] = 1;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j <= sum; j++) {
                if(j - nums[i] >= 0) {
                    dp[i][j] += dp[i - 1][j -nums[i]];
                }
                dp[i][j] += dp[i - 1][j];
            }
        }
        if(dp[nums.length - 1][ sum / 2] != 0 && dp[nums.length - 1][ sum / 2] % 2 == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] argv ) {
        new Solution().canPartition(new int[]{1,2 ,5 });
    }
}
