package leetcode.pro767;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    class Pair {
        char c;
        int cnt;


    }

    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.cnt - o1.cnt;
            }
        });

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            Pair p = new Pair();
            p.c = entry.getKey();
            p.cnt = entry.getValue();
            pq.add(p);
        }

        String ans = "";
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            if(pq.isEmpty() && cur.cnt != 1) {
                return "";
            } else if(pq.isEmpty() && cur.cnt == 1){
                ans += cur.c;
            } else {
                Pair next = pq.poll();
                ans += "" + cur.c + next.c;
                cur.cnt--;
                next.cnt--;
                if(cur.cnt > 0) {
                    pq.add(cur);
                }
                if(next.cnt > 0) {
                    pq.add(next);
                }
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().reorganizeString("aab"));
    }
}
