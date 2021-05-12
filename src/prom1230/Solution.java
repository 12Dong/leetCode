package prom1230;

import java.util.Arrays;

public class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int length = prob.length;
        // 第 i 个 硬币 投完之后 场上有 j 个正面向上的概率
        double[][] dp = new double[length][1000 + 1];
        double inital = 1.0;
        for(int i = 0; i < length; i++){
            dp[i][0] = inital *= (1.0 - prob[i]);
        }
        dp[0][1] = prob[0];
        for(int j = 1; j <= target; j++){
            for(int i = 0; i < length; i++){
                if(i==0 && j==1) continue;

                double t = 0;

                if (i >= 1 && j >= 1) {
                    t = dp[i - 1][j - 1] * prob[i];
                }
                double f = 0;
                if(i >= 1){
                    f = dp[i - 1][j] * (1.0 - prob[i]);
                }
                dp[i][j] = t + f;
            }
        }
//        for(int i = 0; i < length; i++){
//            System.out.println(dp[i][0]);
//        }
        return dp[length - 1][target];
    }

    public static void main(String[] argv){
        System.out.println(new Solution().probabilityOfHeads(prob, target));
    }

//    static double[] prob = new double[]{0.4};
    static double[] prob = new double[]{0.5,0.5, 0.5};

    static int target = 1;
//    static int target = 0;
}
