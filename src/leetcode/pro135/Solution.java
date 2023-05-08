package leetcode.pro135;

import java.util.Arrays;

public class Solution {

//    [1,3,2,2,1]
//    1 2 1 2 1
//    [ 1, 0, 2]
//      1  1  2
    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];
        Arrays.fill(count, 1);
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        for(int i = ratings.length - 2; i >=0; i--) {
            if(ratings[i] > ratings[i + 1] && count[i] <= count[i + 1]) {
                count[i] = count[i + 1] + 1;
            }
        }

        int ans = 0;
        for(int i = 0; i < count.length; i++) {
            ans += count[i];
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().candy(new int[]{1, 0, 2});
    }
}
