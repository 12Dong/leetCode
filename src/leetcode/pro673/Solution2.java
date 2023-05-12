package leetcode.pro673;

import java.util.Arrays;

public class Solution2 {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] maxLength = new int[nums.length];
        Arrays.fill(maxLength, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        maxLength[i] = maxLength[j];
                    } else if(dp[j] + 1 == dp[i]) {
                        maxLength[i] += maxLength[j];
                    }
                }
            }
        }

        int maxL = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(dp[i] > maxL) {
                maxL = dp[i];
                ans = maxLength[i];
            } else if(dp[i] == maxL) {
                ans += maxLength[i];
            }
        }
        return ans;
    }


    public static void main(String[] argv) {
//        System.out.println(new Solution2().findNumberOfLIS(new int[]{1,3,5,4,7}));
//        System.out.println(new Solution2().findNumberOfLIS(new int[]{2,2,2,2,2}));
        System.out.println(new Solution2().findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));

    }
}
