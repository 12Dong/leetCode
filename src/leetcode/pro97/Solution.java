package leetcode.pro97;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if(length3 != length1 + length2){
            return false;
        }
        // dp[i][j] 以 s1[i]结尾 以s2[j]结尾的 能够拼接出 s3 i+j长度的字符串
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true;
        boolean sign = true;
        for(int i = 1; i <= length1; i++){
//            System.out.println(s1.charAt(i - 1) + "  " + s3.charAt(i - 1) + " " + sign);
            if(s1.charAt(i - 1) == s3.charAt(i - 1) && sign){
                dp[i][0] = true;
            } else {
                sign = false;
                dp[i][0] = false;
            }
//            System.out.println(dp[i][0]);
        }
        sign  = true;
        for(int i = 1; i <= length2; i++){
//            System.out.println(s2.charAt(i - 1) + "  " + s3.charAt(i - 1) + " " + sign);
            if(s2.charAt(i - 1) == s3.charAt(i - 1) && sign){
                dp[0][i] = true;
            } else {
                sign = false;
                dp[0][i] = false;
            }
//            System.out.println(dp);
        }

        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1) && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i- 1][j] | dp[i][j - 1];
                } else if(s1.charAt(i - 1) == s3.charAt(i + j -1)){
                    dp[i][j] = dp[i - 1][j];
                } else if(s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
//        for(int i = 0; i <= length1;i ++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[length1][length2];
    }

    public static void main(String[] argv){
        System.out.println(new Solution().isInterleave(s1, s2, s3));
    }

//    static String s1 = "aabcc";
//    static String s1 = "aabcc";
//    static String s1 = "";
//    static String s1 = "aa";
//    static String s1 = "aabc";
    static String s1 = "db";
//    static String s2 = "dbbca";
//    static String s2 = "dbbca";
//    static String s2 = "";
//    static String s2 = "ab";
//    static String s2 = "abad";
    static String s2 = "b";
//    static String s3 = "aadbbbaccc";
//    static String s3 = "aadbbcbcac";
//    static String s3 = "";
//    static String s3 = "abaa";
//    static String s3 = "aabadabc";
    static String s3 = "cbb";


}
