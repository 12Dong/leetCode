package leetcode.pro210;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> ans = new LinkedList<>();
        int[] degree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            Set<Integer> target = map.getOrDefault(prerequisites[i][0], new HashSet<>());
            degree[prerequisites[i][1]] ++;
            target.add(prerequisites[i][1]);
            map.put(prerequisites[i][0], target);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++) {
            if(degree[i] == 0) {
                count++;
                queue.add(i);
                ans.add(i);
            }
        }
        while(!queue.isEmpty()) {
            Integer from = queue.poll();
            Set<Integer> targets = map.get(from);
            if (targets == null) {
                continue;
            }
            for (int target : targets) {
                degree[target]--;
                if (degree[target] == 0) {
                    count++;
                    queue.add(target);
                    ans.add(target);
                }
            }
        }
        int[] array = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            array[i] = ans.get(ans.size() - 1 - i);
        }
        return count == numCourses ? array : new int[]{};

    }

}
