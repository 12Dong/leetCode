package pro50;

public class Solution {
    public double myPow(double x, int n) {
        if(x == 0.0d) {
            return 0.0d;
        }

        long b = n;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }

        double ans = 1.0d;
        while(b != 0) {
            if((b & 1) == 1) {
                ans = ans * x;
            }
            x *= x;
            b = b >> 1;
        }
        return ans;
    }
}
