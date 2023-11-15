package leetcode.pro343;

public class Solution {

    public int integerBreak(int n) {
        if(n == 2) {
            return 1;
        }
        if(n == 3) {
            return 2;
        }
        if(n % 3 == 0) {
            int ans = 1;
            while(n != 0) {
                ans *= 3;
                n -= 3;
            }
            return ans;
        } else if(n % 3 == 2) {
            int ans = 2;
            n -= 2;
            while(n != 0) {
                ans *= 3;
                n -= 3;
            }
            return ans;
        } else {
            int ans = 2 * 2;
            n -= 4;
            while(n != 0) {
                ans *= 3;
                n -= 3;
            }
            return ans;
        }
    }
}
