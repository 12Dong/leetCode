package leetcode.prom873;

import java.util.HashMap;

public class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int length = arr.length;
        // 最后一个 arr[j] 倒数第二个 arr[i] 的最长斐波那契数列长度
        int[][] dp = new int[length][length];
        HashMap<Integer, Integer> index = new HashMap<>();
        dp[0][0] = 1;
        dp[1][2] = 2;
        int result = 1;
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            index.put(arr[i], i);
            for (int j = i - 1; j >= 0; j--) {
                int tar = arr[i] - arr[j];
                if(tar > arr[j]) {
                    dp[j][i] = 2;
                }
                int location;
                if (index.containsKey(tar)) {
                    location = index.get(tar);
                } else {
                    dp[j][i] = 2;
                    continue;
                }
                dp[j][i] = Math.max(dp[j][i], dp[location][j] + 1);
                result = Math.max(result, dp[j][i]);
            }
        }
        return result >=3 ? result : 0;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().lenLongestFibSubseq(arr));
    }

//    static int[] arr = new int[]{1,2,3,4,5,6,7,8};
//    static int[] arr = new int[]{1,3,7,11,12,14,18};
//    static int[] arr = new int[]{2,4,5,6,7,8,11,13,14,15,21,22,34};
    static int[] arr = new int[]{2,4,7,8,9,10,14,15,18,23,32,50};
}
