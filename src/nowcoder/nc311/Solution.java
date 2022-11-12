package nowcoder.nc311;

public class Solution {
    public static int mod = 1000000007;
    public int circle (int n) {
        int k = 10;
        // dp[n][m]
        // 从 0 点出发 走m步 走到 n 点需要的步数
        int[][] dp = new int[k+1][n+1];
        dp[1][1] = 1;
        dp[k-1][1] = 1;
        for(int j = 2; j <= n; j++) {
        for(int i = 0; i < k; i++) {
                //
                dp[i][j] = (dp[(i-1+k)%k][j-1] % 1000000007 + dp[(i+1+k)%k][j-1] % 1000000007) % mod;
            }
        }
        return dp[0][n];
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().circle(3));
        System.out.println(new Solution().circle(2));
        System.out.println(new Solution().circle(4));
    }
}
