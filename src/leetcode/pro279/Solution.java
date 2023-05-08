package leetcode.pro279;

import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        int m =  (int) Math.ceil(Math.sqrt((double) n));
        int[] nums = new int[m];
        for(int i = 1; i <= m; i++) {
            nums[i - 1] = i * i;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int j = 0; j <= n ; j++) {
            for(int i = 0; i < m; i++) {
                if(j - nums[i] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().numSquares(12));
        System.out.println(new Solution().numSquares(13));

    }
}
