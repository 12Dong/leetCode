package prom673;

import java.util.Arrays;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        // 以 x 为末尾的最大递增序列长度
        int[] maxLength = new int[length];
        // 以 x 为末尾的最大递增序列个数
        int[] dp = new int[length];
        int result = 0;
        for(int i = 0; i < length; i++){
            int cnt = 1;
            int maxLengthCnt = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) {
                    maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
                }
                if(maxLength[j] > maxLengthCnt) {
                    cnt = dp[j];
                } else if(maxLength[j] == maxLengthCnt) {
                    cnt += dp[j];
                }
            }
            dp[i] = cnt;
            result = Math.max(dp[i], result);
        }
        return result;
    }

    public static void main(String[] arg){
        System.out.println(new Solution().findNumberOfLIS(nums));
    }

//    public static int[] nums = new int[]{1,3,5,4,7};
    public static int[] nums = new int[]{2,2,2,2,2};

}
