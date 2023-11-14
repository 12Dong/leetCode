package leetcode.pro452;

import java.util.Arrays;

public class Solution2 {

    static class Pair implements Comparable {
        long l;
        long r;

        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Object o) {
            Pair p = (Pair) o;
            if(this.r != p.r) {
                long d = (this.r - p.r);
                return d <= 0 ? -1 : 1;
            } else {
                long d = (this.l - p.r);
                return d <= 0 ? -1 : 1;
            }
        }
    }
    public int findMinArrowShots(int[][] points) {
        Pair[] pairs = new Pair[points.length];
        for(int index = 0; index < points.length; index++) {
            Pair p = new Pair(points[index][0], points[index][1]);
            pairs[index] = p;
        }
        Arrays.sort(pairs);
        int cnt = 0;
        long r = pairs[0].r;
        // 发射位置
        long maxl = pairs[0].l;
        for(int i = 1; i < points.length; i++) {
            if(pairs[i].l <= r) {
                // 有交集
                if(pairs[i].l <= maxl) {
                    // 可以用maxl覆盖区域
                    continue;
                } else {
                    // 右移发射区域
                    maxl = pairs[i].l;
                }
            } else {
                // 发射一箭 清零
                cnt++;
                maxl = pairs[i].l;
                r = pairs[i].r;
            }
        }
        cnt++;
        return cnt;
    }
}
