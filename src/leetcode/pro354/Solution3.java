package leetcode.pro354;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Solution3 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        // 最长上升 O(nlogn)
        int[] ba = new int[envelopes.length];
        int size = 0;
        for(int i = 0; i < envelopes.length; i++) {
            if(size == 0) {
                ba[size] = envelopes[i][1];
                size++;
            } else {
                if(envelopes[i][1] >= ba[size - 1]) {
                    ba[size] = envelopes[i][1];
                    size++;
                } else {
                    int location = binaryFindFirstBiggerE(ba, 0, size - 1, envelopes[i][1]);
                    ba[location] = envelopes[i][1];
                }
            }
        }
        return size;

    }

    public int binaryFindFirstBiggerE(int[] nums, int start, int end, int target) {
        int middle = (start + (end - start) / 2);
        int l = start;
        int r = end;
        while(l <= r) {
            middle = (l + (r - l) / 2);
            if(nums[middle] == target) {
                return middle;
            } else if(target > nums[middle]) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return middle;
    }

    public static void main(String[] argv) {
        new Solution3().maxEnvelopes(new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}});
    }
}
