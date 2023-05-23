package leetcode.pro120;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[2][triangle.get(triangle.size() - 1).size()];
        for(int index = 0; index < triangle.size(); index++) {
            List<Integer> list = triangle.get(index);
            if(index == 0) {
                dp[1][0] = list.get(0);
            } else {
                for(int j = 0; j < list.size(); j++) {
                    if(j != list.size() - 1) {
                        dp[1][j] = Math.min(dp[1][j], dp[0][j] + list.get(j));
                    }
                    if(j - 1 >= 0) {
                        dp[1][j] = Math.min(dp[1][j], dp[0][j - 1] + list.get(j));
                    }
                }
            }
            dp[0] = Arrays.copyOf(dp[1], dp[1].length);
            Arrays.fill(dp[1], Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < dp[0].length; i++) {
            ans = Math.min(ans, dp[0][i]);
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().minimumTotal(Collections.singletonList(Collections.singletonList(-10)));
    }
}
