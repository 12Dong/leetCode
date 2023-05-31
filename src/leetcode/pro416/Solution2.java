package leetcode.pro416;

public class Solution2 {

    public boolean canPartition(int[] nums) {
        boolean[] dp = new boolean[20005];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) {
            return false;
        }
        dp[0] = true;
        for(int i = 0; i < nums.length; i++) {
            for(int j = sum; j >= 0; j--) {
                if(j - nums[i] >= 0 && dp[j - nums[i]]) {
                    dp[j] = true;
                }
            }
        }
        if(dp[sum / 2]) {
            return true;
        } else {
            return false;
        }
    }
}
