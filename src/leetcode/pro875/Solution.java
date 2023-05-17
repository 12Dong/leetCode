package leetcode.pro875;

import java.util.Arrays;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        if(h == piles.length) {
            return piles[piles.length - 1];
        }
        int l = 0;
        int r = piles[piles.length - 1] + 1;
        int ans = Integer.MAX_VALUE;
        while(l < r) {
            int middle = (l + r) / 2;
            boolean result = check(piles, middle, h);
            if(result) {
                r = middle;
                ans = Math.min(ans, middle);
            } else {
                l = middle + 1;
            }
        }
        return ans;
    }

    public boolean check(int[] piles, int consume, int h) {
        int real = 0;
        for(int i = 0; i < piles.length; i++) {
            if(consume >= piles[i]) {
                real ++;
            } else {
                real += Math.ceil(1.0 * piles[i] / consume);
            }
        }
        return real <= h;
    }

    public static void main(String[] argv) {
        new Solution().minEatingSpeed(new int[]{10, 10}, 3);
    }
}
//
//  [3,6,7,11], h = 8
//  4
//  [30,11,23,4,20], h = 5
//  30
//  [30,11,23,4,20], h = 6
//  23
//  [4, 11, 20, 23, 30] h = 7

