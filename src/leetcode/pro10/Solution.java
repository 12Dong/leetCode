package leetcode.pro10;

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
            if(s.charAt(i - 1) != '*'){
                dp[i][0] = false;
            } else if(s.charAt(i - 1) == '*' && sign){
                dp[i][0] = true;
            } else{
                dp[i][0] = false;
            }
            if(s.charAt(i - 1) != '*' && (i < length1) && s.charAt(i) !='*'){
                sign = false;
            }
        }
        sign = true;
        for(int i = 1; i <= length2; i++){
            if(p.charAt(i - 1) != '*'){
                dp[0][i] = false;
            } else if(p.charAt(i - 1) == '*' && sign){
                dp[0][i] = true;
            } else{
                dp[0][i] = false;
            }
            if(p.charAt(i - 1) != '*' && (i < length2) && p.charAt(i) !='*'){
                sign = false;
            }
        }

        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(s.charAt(i - 1) == '.' || p.charAt(j - 1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(s.charAt(i - 1) == '*' || p.charAt(j - 1) == '*'){
                    if(s.charAt(i - 1) == '*') {
                        //插入一个前一个字符
                        boolean result = false;
                        if(s.charAt(i - 2) == p.charAt(j - 1)) {
                            result = dp[i - 1][j - 1] | dp[i][j - 1];
                        } else if(s.charAt(i - 2) == '.') {
                            result = dp[i - 1][j - 1] | dp[i][j - 1];
                        } else {
                            result = false;
                        }
                        dp[i][j] = result | dp[i - 1][j] | dp[i - 2][j];
                    } else if(p.charAt(j - 1) == '*') {
                        // 插入一个前一个字符
                        boolean result = false;
                        if(s.charAt(i - 1) == p.charAt(j - 2)){
                            result = dp[i - 1][j - 1] | dp[i - 1][j];
                        } else if(p.charAt(j - 2) == '.') {
                            result = dp[i - 1][j - 1] | dp[i - 1][j];
                        } else {
                            result = false;
                        }
                        dp[i][j] = result | dp[i][j - 1] | dp[i][j - 2];
                    }
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
//    static String s = "ab";
//    static String s = "aab";
    static String s = "mississippi";
//    static String s = "aaa";
//    static String p = "a";
//    static String p = "a*";
//    static String p = ".*";
//    static String p = "c*a*b";
    static String p = "mis*is*p*.";
//    static String p = ".*";
}
