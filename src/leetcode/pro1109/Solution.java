package leetcode.pro1109;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] c = new int[n + 1];
        for(int[] booking : bookings) {
            int from = booking[0] - 1;
            int to = booking[1];
            int value =booking[2];
            c[from] += value;
            c[to] -= value;
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                ans[i] = c[0];
            } else {
                ans[i] = ans[i - 1] + c[i];
            }
        }
        return ans;
    }
}
