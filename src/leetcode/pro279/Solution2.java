package leetcode.pro279;

import java.util.Arrays;

public class Solution2 {

    public int numSquares(int n) {
        int[] base = new int[100];
        int size = 1;
        for(;size * size <= n; size++) {
            int location = size - 1;
            base[location] = size * size;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < size && i >= base[j]; j++) {
                if(i - base[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - base[j]] + 1);
                }
            }
        }
        return dp[n];
    }
}
