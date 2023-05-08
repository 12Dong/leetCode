package leetcode.prom673;

import java.util.Arrays;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        // 以 x 为末尾的最大递增序列长度
        int[] maxLength = new int[length];
        // 以 x 为末尾的最大递增序列个数
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int result = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) {
                    if(maxLength[j] + 1 > maxLength[i]) {
                        maxLength[i] = maxLength[j] + 1;
                        dp[i] = dp[j];
                    } else if(maxLength[j] + 1 == maxLength[i]) {
                        dp[i] += dp[j];
                    }
                }
            }
            result = Math.max(maxLength[i], result);
        }
        int cnt = 0;
//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(maxLength));
        for(int i = 0; i < length; i++){
            if(maxLength[i] == result) {
                cnt += dp[i];
            }
        }
        return cnt;
    }

    public static void main(String[] arg){
        System.out.println(new Solution().findNumberOfLIS(nums));
    }

//    public static int[] nums = new int[]{1,3,5,4,7};
    public static int[] nums = new int[]{2,2,2,2,2};
//    public static int[] nums = new int[]{1,2,4,3,5,4,7,2};
}
