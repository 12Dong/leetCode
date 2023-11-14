package leetcode.pro210;

import java.util.*;

public class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] dependency = new int[numCourses];
        Map<Integer, Set<Integer>> dMap = new HashMap<>();
        for(int[] d : prerequisites) {
            int from = d[1];
            int to = d[0];
            Set<Integer> set = dMap.getOrDefault(from, new HashSet<>());
            set.add(to);
            dMap.put(from, set);
            dependency[to]++;
        }

        int index = 0;
        int[] ans = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(dependency[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int from = q.poll();
            ans[index++] = from;
            Set<Integer> toSet = dMap.get(from);
            if(toSet == null) {
                continue;
            }
            for(Integer to : toSet) {
                dependency[to]--;
                if(dependency[to] == 0) {
                    q.add(to);
                }
            }
        }

        for(int i = 0; i < dependency.length; i++) {
            if(dependency[i] != 0) {
                return new int[]{};
            }
        }
        return ans;
    }
}
