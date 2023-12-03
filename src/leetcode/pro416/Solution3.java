package leetcode.pro416;

public class Solution3 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) {
            return false;
        }
        int size = sum / 2;
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++) {
            for(int j = size; j >= 0; j--) {
                if(j - nums[i] >= 0) {
                    dp[j] = dp[j] | dp[j - nums[i]];
                }
            }
        }
        return dp[size];
    }

    public static void main(String[] argv) {
        new Solution3().canPartition(new int[]{1,2,5});
    }
}
