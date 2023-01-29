package nowcoder.nc311;

public class Solution2 {
    public static Integer mod = 1000000007;
    public int circle (int n) {
        int[][] dp = new int[n + 1][10];
        dp[1][1] = 1;
        dp[1][9] = 1;
        for(int i = 2; i <= n; i ++) {
            for(int j = 0; j <= 9; j++) {
                int l = (j - 1 + 10) % 10;
                int r = (j + 1) % 10;
                System.out.println(" l " + l + " r " + r);
                dp[i][j] = (dp[i - 1][l] % mod +   dp[i-1][r] % mod) % mod;
            }
        }
        return dp[n][0];
    }

    public static void main(String[] argv) {
        System.out.println((-1) % 10);
        System.out.println(new Solution2().circle(3));
    }
}
