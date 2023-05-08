package leetcode.pro96;

public class Solution2 {

    public static int[] dp = new int[20];

    static {
        dp[1] = 1;
        dp[2] = 2;
    }
    public int numTrees(int n) {
        if(n == 0) return 1;
        if(dp[n] != 0) return dp[n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            cnt += (numTrees(i) * numTrees(n - i -1));
        }
        dp[n] = cnt;
        return cnt;
    }
}
