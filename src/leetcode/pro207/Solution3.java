package leetcode.pro207;

import java.util.*;

public class Solution3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        Map<Integer, Set<Integer>> dependencyMap = new HashMap<>();
        for(int[] quisite : prerequisites) {
            int from = quisite[1];
            int to = quisite[0];
            degree[to]++;
            Set<Integer> dependency = dependencyMap.getOrDefault(from, new HashSet<>());
            dependency.add(to);
            dependencyMap.put(from, dependency);
        }

        int cnt = numCourses;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(degree[i] == 0) {
                queue.add(i);
                cnt--;
            }
        }

        while(!queue.isEmpty()) {
            int from = queue.poll();
            Set<Integer> dependency = dependencyMap.get(from);
            if(dependency == null || dependency.isEmpty()) {
                continue;
            } else {
                for(Integer to : dependency) {
                    degree[to]--;
                    if(degree[to] == 0) {
                        queue.add(to);
                        cnt--;
                    }
                }
            }
        }

        return cnt == 0;

    }

    public static void main(String[] argv) {
        new Solution3().canFinish(2, new int[][]{});
    }
}
