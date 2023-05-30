package leetcode.pro1011;

public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int cnt = 0;
        int l = 1;
        for(int i = 0; i < weights.length; i++) {
            l = Math.max(l, weights[i]);
            cnt += weights[i];
        }
        if(days == 1) {
            return cnt;
        }

        int r = cnt;
        int ans = Integer.MAX_VALUE;
        while(l < r) {
            int middle = (l + r) / 2;
            boolean result = check(weights, days, middle);
            if(result) {
                ans = Math.min(ans, middle);
                r = middle;
            } else {
                l = middle + 1;
            }
        }
        return ans;
    }

    public boolean check(int[] weights, int days, int ship) {
        int need = 1;
        int cur = 0;
        for(int i = 0; i < weights.length; i++) {
            if(cur + weights[i] > ship) {
                need++;
                cur = weights[i];
            } else {
                cur+= weights[i];
            }
        }
        return need <= days;
    }

    public static void main(String[] argv) {
        new Solution().shipWithinDays(new int[]{10,50,100,100,50,100,100,100}, 5);
    }
//    [10,50,100,100,50,100,100,100]
//5
}
