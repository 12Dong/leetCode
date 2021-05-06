package prom1027;

import java.util.*;

public class Solution {
    public int longestArithSeqLength(int[] A) {
        int length = A.length;
        // 最后一个 arr[j] 倒数第二个 arr[i] 的最长等差数列长度
        int[][] dp = new int[length][length];
        HashMap<Integer, List> index = new HashMap<>();
        dp[0][0] = 1;
        dp[0][1] = 2;
        int result = 2;
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            if(index.containsKey(A[i])){
                List list = index.get(A[i]);
                list.add(i);
                index.put(A[i], list);
            } else {
                List list = new LinkedList();
                list.add(i);
                index.put(A[i], list);
            }
            for (int j = i - 1; j >= 0; j--) {
                int dif = A[i] - A[j];

                int tar = A[j] - dif;

//                if(tar > A[j]) {
//                    dp[j][i] = 2;
//                }
                List locations;
                if (index.containsKey(tar)) {
                    locations = index.get(tar);
                } else {
                    dp[j][i] = 2;
                    result = Math.max(result, dp[j][i]);
                    continue;
                }
                if(dif != 0) {
                    for(Object location : locations){
                        if((int)location > j) dp[j][i] = Math.max(dp[j][i], 2);

                        dp[j][i] = Math.max(dp[j][i], dp[(int)location][j] + 1);
                    }
                } else {
//                    System.out.println("i : " + i + " j : " + j + " " +  locations.size());
                    dp[j][i] = Math.max(dp[j][i], locations.size());
                }
                result = Math.max(result, dp[j][i]);
            }
        }
        return result;

    }

    public static void main(String[] argv){
        System.out.println(new Solution().longestArithSeqLength(A));
//        List<Integer> list = Arrays.asList(A);
//        System.out.println(list.size());
//        System.out.println(new HashSet<>(list).size());
    }

//    static int[] A = new int[]{3,6,9,12};
//    static int[] A = new int[]{9,4,7,2,10};
//    static int[] A = new int[]{20,1,15,3,10,5,8};
//    static int[] A = new int[]{83,20,17,43,52,78,68,45};
//    static int[] A = new int[]{44,46,22,68,45,66,43,9,37,30,50,67,32,47,44,11,15,4,11,6,20,64,54,54,61,63,23,43,3,12,51,61,16,57,14,12,55,17,18,25,19,28,45,56,29,39,52,8,1,21,17,21,23,70,51,61,21,52,25,28};
    static int[] A = new int[]{1,1,1,1,1};
}
