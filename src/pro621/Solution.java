package pro621;

import java.util.*;

public class Solution {

    class P implements Comparable {
        Character c;
        int t;

        P(Character c, int t) {
            this.c = c;
            this.t = t;
        }

        @Override
        public int compareTo(Object o) {
            P p = (P) o;
            return p.t -this.t;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<P> pq = new PriorityQueue<>();
        for(Character c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for(Map.Entry<Character, Integer> entry : set) {
            pq.add(new P(entry.getKey(), entry.getValue()));
        }
        P curP = pq.poll();
        int bucket = curP.t;
        int lastBucket = 1;
        while(!pq.isEmpty()) {
            P p = pq.poll();
            if(p.t == bucket) {
                lastBucket++;
            } else {
                break;
            }
        }
        return Math.max(tasks.length, (bucket - 1) * (n + 1)  + lastBucket);
    }

    public static void main(String[] argv) {
        char[] chars = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(new Solution().leastInterval(chars, 2));
        chars = new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(new Solution().leastInterval(chars, 2));
    }
}
