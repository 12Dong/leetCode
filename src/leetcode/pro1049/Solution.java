package leetcode.pro1049;

import java.util.Arrays;

public class Solution {

//  31,26,33,21,40
//  31 5  24  3  5
//     26  7 14 14
//        33 12 14
//           19 40

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int[][] dp = new int[stones.length][stones.length];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int i = n - 1; i >= 0; i --) {
            for(int j = i; j < n; j++) {
                if(j == i) {
                    dp[i][j] = stones[i];
                } else if(j - i == 1) {
                    dp[i][j] = Math.abs(stones[i] - stones[j]);
                } else if(j - i >= 2){
                    dp[i][j] = Math.min(dp[i][j], Math.abs(Math.abs(stones[i]-stones[j]) - dp[i+1][j-1]));
                    dp[i][j] = Math.min(dp[i][j], Math.abs(Math.abs(stones[i]-dp[i+1][j-1]) - stones[j]));
                    dp[i][j] = Math.min(dp[i][j], Math.abs(Math.abs(stones[j]-dp[i+1][j-1]) - stones[i]));
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
}
