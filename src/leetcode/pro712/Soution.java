package leetcode.pro712;

import java.util.Arrays;

public class Soution {
    public int minimumDeleteSum(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        //以 s1 第i个字符结尾 以 s2 第j个字符结尾的最小ascii 删除字符最小和
        int[][] dp = new int[length1 + 1][length2 + 1];

        for(int i = 0; i <= length1; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i <= length1; i++){
            if(i == 0){
                dp[i][0] = 0;
            } else{
                dp[i][0] = dp[i - 1][0] + (int)s1.charAt(i - 1);
            }
        }

        for(int i = 0; i <= length2; i++){
            if(i == 0){
                dp[0][i] = 0;
            } else{
                dp[0][i] = dp[0][i - 1] + (int)s2.charAt(i - 1);
            }
        }

        for(int i = 1; i <= length1; i++){
            for(int j = 1;j <= length2; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i -1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i -1][j] + (int)s1.charAt(i -1),
                                        dp[i][j -1] + (int)s2.charAt(j -1));
                }
            }
        }
//        for(int i = 0; i <= length1;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[length1][length2];
    }

    public static void main(String[] argv){
        System.out.println(new Soution().minimumDeleteSum(s1, s2));
//        System.out.println((int)'t');
    }

    static String s1 = "sea";

    static String s2 = "eat";
}
