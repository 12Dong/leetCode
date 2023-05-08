package leetcode.pro44;

public class Solution {

    public boolean isMatch(String s, String p) {
        int length1 = s.length();
        int length2 = p.length();
        // dp[i][j] s 以 第 i 个字符结尾 p 以 第 j 个字符结尾 的状态
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true;
        //连续 *
        boolean sign = true;
        for(int i = 1; i <= length1; i++){
            if(sign && s.charAt(i - 1) == '*'){
                dp[i][0] = true;
            } else {
                dp[i][0] = false;
                sign = false;
            }
        }
        sign = true;
        for(int i = 1; i <= length2; i++){
            if(sign && p.charAt(i - 1) == '*'){
                dp[0][i] = true;
            } else {
                dp[0][i] = false;
                sign = false;
            }
        }

        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(s.charAt(i -1) == '*' || p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i -1][j - 1] | dp[i - 1][j] | dp[i][j - 1];
                } else if(s.charAt(i - 1) == '?' || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(s.charAt(i - 1) == p.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j -1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
//        for(int i = 0; i <= length1; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[length1][length2];
    }

    public static void main(String[] argv){
        System.out.println(new Solution().isMatch(s, p));
    }

//    static String s = "aa";
//    static String s = "aa";
//    static String s = "cb";
//    static String s = "adceb";
    static String s = "acdcb";
//    static String p = "a";
//    static String p = "*";
//    static String p = "?a";
//    static String p = "*a*b";
    static String p = "a*c?b";
}
