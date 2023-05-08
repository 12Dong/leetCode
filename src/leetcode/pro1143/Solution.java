package leetcode.pro1143;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        // 以 text1 第 i个字符结束 以 text2 第j个字符结束的最长公共子序列
        int[][] dp = new int[length1 + 1][length2 + 1];
        int result = 0;
        for(int i = 1; i <= length1; i++){
            for( int j = 1; j <= length2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                result = Math.max(dp[i][j], result);
            }
        }
        return result;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().longestCommonSubsequence(text1, text2));
    }

    static String text1 = "abcde";

    static String text2 = "ace";
}
