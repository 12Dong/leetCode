package prom746;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        // 到 第 x 级楼梯 所需要花费的最小体力
        int[] dp = new int[length];
        dp[0] = 0;
        if(length >= 1) dp[1] = 0;
        for(int i = 2; i < length; i++){
            dp[i] = Math.min(dp[i-2] + cost[i -2], dp[i-1] +cost[i-1]);
        }
        return Math.min(dp[length - 1] + cost[length - 1], dp[length - 2] + cost[length -2]);
    }

    public static void main(String[] argv){
        System.out.println(new Solution().minCostClimbingStairs(cost));
    }

//    public static int[] cost = new int[]{10, 15, 20};
    public static int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
}
