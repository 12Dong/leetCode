package leetcode.pro354;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int[] nums = new int[envelopes.length];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = envelopes[i][1];
        }

        int[] lis = new int[nums.length];
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            int l = 0;
            int r = index;
            while(l < r) {
                int mid = l + (r - l) >> 1;
                if(lis[mid] >= nums[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if(l == index) {
                index++;
            }
            lis[l] = nums[i];
        }
        return index;
    }

    public static void main(String[] argv) {
        new Solution2().maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}});
    }
}
