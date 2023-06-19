package leetcode.pro377;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int j = 1; j <= target; j++){
        for(int i = 0; i < nums.length; i++) {
                if(j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().combinationSum4(new int[]{1,2,3}, 4));
    }
}
