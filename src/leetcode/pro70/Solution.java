package leetcode.pro70;

public class Solution {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int dpm1 = 1;
        int dpm2 = 1;
        int dpc = dpm1 + dpm2;
        for(int i = 2; i <= n; i++) {
            dpc = dpm1 + dpm2;
            dpm2 = dpm1;
            dpm1 = dpc;
        }
        return dpc;
    }
}
