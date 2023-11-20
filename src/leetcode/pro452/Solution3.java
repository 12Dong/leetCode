package leetcode.pro452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) {
                    long tmp = (long)o1[1] - (long)o2[1];
                    return tmp < 0 ? -1 : 1;
                } else {
                    long tmp = (long)o1[0] - (long)o2[0];
                    return tmp < 0 ? -1 : 1;
                }
            }
        });
        int cnt = 0;
        if(points.length == 0) {
            return 0;
        }
        // 当前jian 射出的最大范围
        int r = points[0][1];
        int l = points[0][0];
        for(int i = 1; i < points.length; i++ ) {
            if(points[i][0] <= r) {
                l = Math.max(l, points[i][0]);
            } else {
                r = points[i][1];
                l = points[i][0];
                cnt++;
            }
        }
        cnt++;
        return cnt;
    }

    public static void main(String[] argv) {
        new Solution3().findMinArrowShots(new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}});
    }

}
