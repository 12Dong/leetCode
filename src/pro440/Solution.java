package pro440;

import java.util.PriorityQueue;

public class Solution {
    public static int findKthNumber(int n, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            if(pq.size() < k) {
                pq.add(s);
            } else {
                pq.remove(k);
                pq.add(s);
            }
        }
        for(int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return Integer.valueOf(pq.poll());
    }
}
