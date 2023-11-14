package leetcode.pro1049;

import leetcode.pro354.Solution;

public class Solution2 {
    public int lastStoneWeightII(int[] stones) {
        int weight = 0;
        for(int i = 0; i < stones.length; i++) {
            weight += stones[i];
        }
        int limit = weight / 2;
        boolean[] dp = new boolean[limit + 1];
        dp[0] = true;
        int max = 0;
        for(int j = 0; j < stones.length; j++) {
            for(int i = limit; i > 0; i--) {
                if(i - stones[j] >= 0) {
                    dp[i] = dp[i] | dp[i - stones[j]];
                }
                if(dp[i]) {
                    max = Math.max(max, i);
                }
            }

        }
        return weight - 2 * max;
    }

    public static void main(String[] argfv) {
        new Solution2().lastStoneWeightII(new int[]{2,7,4,1,8,1});
    }
}
