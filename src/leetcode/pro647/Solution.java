package leetcode.pro647;

public class Solution {
    public int countSubstrings(String s) {
        int[] dp = new int[s.length() * 2 + 1];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        String ss = "$";
        for(int i = 0; i < s.length(); i++) {
            ss += s.charAt(i);
            ss += "$";
        }
        int cnt = s.length();
        for(int i = 0; i < ss.length(); i++) {
            int l = i - 1;
            int r = i + 1;
            while(l >=0 && r < ss.length()) {
                if(ss.charAt(l) == ss.charAt(r)) {
                    if(ss.charAt(l) != '$') {
                        cnt++;
                    }
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().countSubstrings("aaabaaa"));
    }
}
