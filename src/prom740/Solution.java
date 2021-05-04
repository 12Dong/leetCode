package prom740;

import java.sql.PreparedStatement;
import java.util.Arrays;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int[] totals = new int[1200];
        int index = 0;
        for(int i = 0;i < length;i++){
            totals[nums[i]] += nums[i];
        }
//        System.out.println(Arrays.toString(totals));
        int[] dp = new int[1200];
        dp[0] = totals[0];
        dp[1] = Math.max(dp[0], totals[1]);
        int result = Math.max(dp[0], dp[1]);
        for(int i = 2; i< 1200; i++){
            dp[i] = Math.max(dp[i - 2] + totals[i], dp[i-1]);
            result = Math.max(result, dp[i]);
        }
//        System.out.println(Arrays.toString(dp));
        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().deleteAndEarn(nums));
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
    }

//    static int[] nums = new int[]{3, 4, 2};
//    static int[] nums = new int[]{8,10,4,9,1,3,5,9,4,10};
    static int[] nums = new int[]{2, 2, 3, 3, 3, 4};
//    static int[] nums = new int[]{3};
}
