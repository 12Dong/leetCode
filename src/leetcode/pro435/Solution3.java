package leetcode.pro435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {
    public int eraseOverlapIntervals(int[][] intervals) {
        ThreadLocal
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        if(intervals.length == 0) {
            return 0;
        }
        int r = intervals[0][1];
        int l = intervals[0][0];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= r) {
                // 新开区间
                l = intervals[i][0];
                r = intervals[i][1];
                cnt++;
            }
        }
        return intervals.length - cnt;
    }
}
