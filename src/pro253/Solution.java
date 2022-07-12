package pro253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]    ;
            }
        });
        int ans = Integer.MIN_VALUE;

        for(int[] meeting : intervals) {
            if(queue.isEmpty()) {
                queue.add(meeting[1]);
                ans = Integer.max(queue.size(), ans);
                continue;
            }
            while(!queue.isEmpty() && queue.peek() <= meeting[0]) {
                queue.poll();
            }
            queue.add(meeting[1]);
            ans = Integer.max(queue.size(), ans);
        }
        return ans;
    }
}
