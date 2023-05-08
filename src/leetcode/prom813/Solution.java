package leetcode.prom813;

public class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[A.length][K + 1];
        int[] suffixSum = new int[A.length];
        int length = A.length;
        for(int i = 0; i < length; i++){
            if(i == 0) {
                suffixSum[i] = A[i];
                continue;
            }
            suffixSum[i] = suffixSum[i - 1] + A[i];
        }
        double result = Integer.MIN_VALUE;

        for(int i = 0; i < length; i ++) {
            dp[i][1] = suffixSum[i] / (double)(i + 1);

        }
        result = Math.max(dp[length - 1][1], result);

            for(int k = 2; k <= K; k++){
                for(int i = 0; i < length; i++){
                    for(int j = 0; j < i; j++) {
                        if(i + 1 < k) continue;
                        double avg = suffixSum[i] - suffixSum[j];
                        avg = avg / (i - j);
    //                    System.out.println("i : " + i + "  j : " + j + " k : " + k);
    //                    System.out.println(dp[j][k - 1] + avg);
                        dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + avg);
//                        if(k == 4) {
//                            System.out.println("========");
//                            System.out.println(i + " " + j);
//                            System.out.println(dp[j][k -1] + "  " + avg);
//                            System.out.println(dp[j][k - 1] + avg);
//                        }


                }
                }
                result = Math.max(dp[length - 1][k], result);
        }
        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().largestSumOfAverages(A, K));
    }

//    static int[] A = new int[]{9,1,2,3,9};
//    static int[] A = new int[]{1,1,1, 1, 1, 1};
    static int[] A = new int[]{1,2,3,4,5,6,7};
//    static int[] A = new int[]{4,1,7,5,6,2,3};
    static int K = 4;
}
