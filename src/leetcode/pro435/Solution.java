package leetcode.pro435;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {

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
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        List<Pair> list = new LinkedList<>();
        for(int[] interval : intervals) {
            Pair pair = new Pair();
            pair.l = interval[0];
            pair.r = interval[1];
            list.add(pair);
        }
        list = list.stream().sorted().collect(Collectors.toList());
        int max = 0;
        int r = Integer.MIN_VALUE;
        for(Pair pair : list) {
            if(pair.l >= r) {
                r = pair.r;
                max++;
            }
        }

        return intervals.length - max;
    }

    public static void main(String[] argv) {
        new Solution().eraseOverlapIntervals(new int[][]{{1,2}, {2,3}, {3,4}, {1,3}});
    }
}

// [
// [-73,-26]
// [-65,-11],
// [-63,2],
// [-62,-49],
// [-52,31],
// [-40,-26]
// [-31,49],
// [30,47]
// [58,95],
// [66,98]
// [82,97],
// [95,99],,,]
