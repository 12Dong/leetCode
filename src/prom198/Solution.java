package prom198;

import org.omg.CORBA.IRObject;

public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        if(length < 2) return nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        int result = dp[1];
        for(int i = 2; i < length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().rob(nums));
    }

//    static int[] nums = new int[]{1, 2,3, 1};
    static int[] nums = new int[]{2, 7, 9, 3, 1};
}
