package prom813;

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

        for(int i = 0; i < length; i++){
            dp[i][0] = 0;
            for(int j = 0; j < i; j++){
                for(int k = 1; k <= K; k++){
                    if(i + 1 < k) continue;
                    double avg = suffixSum[i] - suffixSum[j];
                    avg = avg / (i - j);
                    System.out.println("i : " + i + "  j : " + j + " k : " + k);
                    System.out.println(dp[j][k - 1] + avg);
                    dp[i][k] = Math.max(dp[i][k], dp[j][k-1] + avg);
                    result = Math.max(dp[i][k], result);
                }
            }
        }
        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().largestSumOfAverages(A, K));
    }

    static int[] A = new int[]{9,1,2,3,9};
    static int K = 3;
}
