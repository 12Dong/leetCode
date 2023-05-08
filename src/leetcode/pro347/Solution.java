package leetcode.pro347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for(int key : map.keySet()) {
            if(queue.size() < k) {
                queue.add(key);
            } else if(map.get(queue.peek()) < map.get(key)) {
                queue.poll();
                queue.add(key);
            }
        }
        int[] ans = new int[k];
        int step = 0;
        while(!queue.isEmpty()) {
            ans[step] = queue.poll();
            step++;
        }
        return ans;
    }
}
