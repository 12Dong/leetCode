package leetcode.pro435;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    static class Pair implements Comparable {
        int l;
        int r;

        @Override
        public int compareTo(Object o) {
            Pair p = (Pair) o;
            if(this.r != p.r) {
                return this.r - p.r;
            } else {
                return this.l - p.l;
            }
        }

        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    public static  int eraseOverlapIntervals(int[][] intervals) {
        Pair[] pairs = new Pair[intervals.length];
        for(int index = 0; index < intervals.length; index ++) {
            Pair pair = new Pair(intervals[index][0], intervals[index][1]);
            pairs[index]= pair;
        }

        Arrays.sort(pairs);
        int size = 1;
        int max = 1;
        int r = pairs[0].r;
        for(int i = 1; i < pairs.length; i++) {
            if(pairs[i].l >= r) {
                r = pairs[i].r;
                size++;
            }
        }

        return intervals.length - max;
    }

    public static void main(String[] argv) {
        eraseOverlapIntervals(new int[][]{{1,2}, {2,3},{3,4},{1,3}});
    }
}
