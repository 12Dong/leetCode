package leetcode.pro91;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numDecodings(String s) {
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= 26; i++) {
            set.add(new String("" + i));
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i = 0; i < s.length(); i++) {
            if(!(set.contains(s.charAt(i) + "") || (i-1>=0 && set.contains(s.charAt(i-1) + "" + s.charAt(i))))) {
                return 0;
            }
        }
        for(int i = 1; i < s.length(); i++) {
            if(set.contains(new String(s.charAt(i) + ""))) {
                dp[i] += dp[i - 1];
            }
            String str = s.charAt(i - 1) + "" + s.charAt(i);
            if(set.contains(str)) {
                if(i - 2 >= 0) {
                    dp[i] += dp[i - 2];
                } else {
                    dp[i] ++;
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] argv) {
        String str = "12";
        String s = str.charAt(0) + "" + str.charAt(1);
        new Solution().numDecodings("06");
    }
}
