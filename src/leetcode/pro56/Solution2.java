package leetcode.pro56;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        if(intervals.length == 1) {
            return intervals;
        }
        int r = intervals[0][1];
        int l = intervals[0][0];
        for(int i = 1; i < intervals.length; i++) {
            if(r < intervals[i][0]) {
                int[] tmp = new int[2];
                tmp[0] = l;
                tmp[1] = r;
                list.add(tmp);
                l = intervals[i][0];
                r = intervals[i][1];
            } else {
                r = Math.max(r, intervals[i][1]);
            }
        }
        int[] tmp = new int[2];
        tmp[0] = l;
        tmp[1] = r;
        list.add(tmp);
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }
}
