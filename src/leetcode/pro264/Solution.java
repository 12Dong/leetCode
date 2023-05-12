package leetcode.pro264;

import java.util.*;

public class Solution {
    public int nthUglyNumber(int n) {
        int cnt = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        cnt = 0;
        Set<Long> set = new HashSet<>();
        set.add(1L);
        long ans = 1;
        while(cnt < n) {
            long min = pq.poll();
            ans = min;
            cnt++;
            if(!set.contains(min * 2)) {
                pq.add(min * 2);
                set.add(min * 2);
            }
            if(!set.contains(min * 3)) {
                pq.add(min * 3);
                set.add(min * 3);
            }
            if(!set.contains(min * 5)) {
                pq.add(min * 5);
                set.add(min * 5);
            }
        }
        return (int)ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().nthUglyNumber(1690));
    }
}
