package aModule;

public class DDD {

    /**
     * aaabccbabb
     * abccba
     */

    public String findMax(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for(int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }
        for(int i = 0; i < str.length(); i++) {
            for(int j = i - 1; j >=0 ; j--) {
                if(str.charAt(i) == str.charAt(j)) {
                    if(j == i - 1) {
                        dp[j][i] = 2;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1] + 2;
                    }
                }
            }
        }

        int ans = 0;
        String ansS = "";
        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < str.length(); j ++ ) {
                if(dp[i][j] > ans) {
                    ans = dp[i][j];
                    ansS = str.substring(i, j + 1);
                }
            }
        }
        return ansS;
    }

    public static void main(String[] argv) {
        new DDD().findMax("a");
    }
}
