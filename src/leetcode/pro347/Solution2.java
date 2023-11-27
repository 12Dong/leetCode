package leetcode.pro347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution2 {
    class Pair {
        int value;
        int cnt;
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1 );
        }
        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.cnt - o1.cnt;
            }
        });
        for(Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            Pair p = new Pair();
            p.value = entry.getKey();
            p.cnt = entry.getValue();
            q.add(p);
        }
        int[] ans = new int[k];
        int index = 0;
        while(k > 0) {
            ans[index] = q.poll().value;
            index++;
            k--;
        }
        return ans;
    }
}
