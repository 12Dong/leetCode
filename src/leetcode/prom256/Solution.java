package leetcode.prom256;

import java.util.Arrays;

public class Solution {
    public int minCost(int[][] costs) {
        int length = costs.length;
        // 第 i 栋房子 涂了 R->0 B->1 G->2 之后的最小花费
        int[][] dp = new int[length][3];
        for(int[] dpS : dp){
            Arrays.fill(dpS, Integer.MAX_VALUE);
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0;i < length; i++){
            for(int j = 0; j < 3; j++){
                if(i == 0) {
                    dp[i][j] = costs[i][j];
                    continue;
                }
                for(int k = 0; k < 3;k++){
                    if(j == k) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + costs[i][j]);
                }
            }
//            System.out.println(Arrays.toString(dp[i]));
        }
        for(int i = 0; i < 3; i++){
            result = Math.min(dp[length-1][i], result);
        }
        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().minCost(costs));
    }

    static int[][] costs = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
}
