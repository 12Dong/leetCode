package leetcode.prom213;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        if(length < 2) return nums[0];
        int first = nums[0];
        nums = Arrays.copyOfRange(nums, 1, length + 1);
        nums[length - 1] = first;
        System.out.println(Arrays.toString(nums));
        dp[0] = nums[0];

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
        static int[] nums = new int[]{2, 3, 2};
//        static int[] nums = new int[]{1, 2,3, 1};
//    static int[] nums = new int[]{2, 7, 9, 3, 1};
//        static int[] nums = new int[]{0};

}
