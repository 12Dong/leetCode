package leetcode.pro139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution4 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        // 第 i - 1 结尾的 子字符串 是否能拼成
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for(int i = 1; i <= s.length(); i++) {
            for(String cur : set) {
                int length = cur.length();
                if(i - length >= 0) {
                    if(dp[i - length]) {
                        String comare = s.substring(i - length, i);
                        if(comare.equals(cur)) {
                            dp[i] = true;
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
