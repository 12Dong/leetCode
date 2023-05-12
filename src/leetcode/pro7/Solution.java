package leetcode.pro7;

public class Solution {
    public int reverse(int x) {
        if(x == 0) {
            return x;
        }
        boolean sign = x >= 0;
        if(x == Integer.MIN_VALUE) {
            return 0;
        }
        x = Math.abs(x);
        int ans = 0;
        while(x > 0) {
            int mod = x % 10;
            x /= 10;
            if(ans == (Integer.MAX_VALUE - mod + 1) * 1.0 / 10) {
                if(x == 0) {
                    return Integer.MIN_VALUE;
                } else {
                    return 0;
                }
            }
            if(ans > (Integer.MAX_VALUE - mod) * 1.0 / 10) {
                return 0;
            } else {
                ans = ans * 10 + mod;
            }
        }
        if(sign) {
            return ans;
        } else {
            return -ans;
        }
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().reverse(123));
    }
}
