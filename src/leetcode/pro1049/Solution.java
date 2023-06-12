package leetcode.pro1049;

public class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i = 0; i < stones.length; i++) {
            sum+= stones[i];
        }
        boolean[] dp = new boolean[sum/2 + 1];
        dp[0] = true;
        for(int i = 0; i < stones.length; i++) {
            for(int j = dp.length - 1; j >= 0; j--) {
                if(j - stones[i] >= 0 && dp[j - stones[i]]) {
                    dp[j] = true;
                }
            }
        }

        int sum1 = 0;
        for(int i = dp.length - 1; i >= 0; i--) {
            if(dp[i]) {
                sum1 = i;
                break;
            }
        }
        return Math.abs(sum - sum1 - sum1);
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().lastStoneWeightII(new int[]{2,7,4,1,8,1}));
    }
}
