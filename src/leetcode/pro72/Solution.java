package leetcode.pro72;

import java.util.Arrays;

public class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        // dp[i][j] 以 word1[i] 结尾 以 word[j] 结尾的最小变化次数
        int[][] dp = new int[length1 + 1][length2 + 1];
        for(int i = 0; i <= length1; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i <= length1;i ++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= length2;i++){
            dp[0][i] = i;
        }
        for(int i = 1; i <= length1; i++){
            boolean sign = true;
            for(int j = 1; j <= length2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1) && sign){
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
//                    sign = !sign;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                    dp[i][j] += 1;
                }
            }
//            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[length1][length2];
    }

    public static void main(String[] argv){
        System.out.println(new Solution().minDistance(word1, word2));
    }

//    static String word1 = "horse";
//    static String word1 = "intention";
//    static String word1 = "kitten";
    static String word1 = "zoologicoarchaeologist";
//    static String word2 = "ros";
//    static String word2 = "execution";
//    static String word2 = "sitting";
    static String word2 = "zoogeologist";
}
