package leetcode.pro452;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

        static class Pair implements Comparable{
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
                    long c = this.r - p.r;
                    return c >= 0 ? 1 : -1;
                } else {
                    long c= p.l - this.l;
                    return c >= 0 ? 1 : -1;
                }
            }
        }
        public int findMinArrowShots(int[][] points) {
            List<Pair> pairList = new LinkedList<>();
            for(int i = 0; i < points.length; i++) {
                Pair pair = new Pair(points[i][0], points[i][1]);
                pairList.add(pair);
            }
            pairList = pairList.stream().sorted().collect(Collectors.toList());

            int ans = 0;
            long l = -1;
            long r = -1;
            for(Pair pair : pairList) {
                if(l == -1) {
                    l = pair.l;
                    r = pair.r;
                    ans++;
                } else {
                    if(r >= pair.l) {
                        l = Math.min(l, pair.l);
                        r = Math.min(r, pair.r);
                    } else {
                        l = pair.l;
                        r = pair.r;
                        ans++;
                    }
                }
            }
            return ans;
        }

    public static void main(String[] argv) {
//        new Solution().findMinArrowShots(new int[][]{{-2147483646,-2147483645}, {2147483646,2147483647}});
//        new Solution().findMinArrowShots(new int[][]{{1,2}, {3,4}, {5,6}, {7,8}});
        new Solution().findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}});

    }
//[[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]
//[[],[]]
}
