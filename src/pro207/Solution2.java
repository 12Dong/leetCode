package pro207;

import java.util.*;

public class Solution2 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
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
                }
            }
            while(!queue.isEmpty()) {
                Integer from = queue.poll();
                Set<Integer> targets = map.get(from);
                if(targets == null) {
                    continue;
                }
                for(int target : targets) {
                    degree[target] --;
                    if(degree[target] == 0) {
                        count++;
                        queue.add(target);
                    }
                }
            }

            return count == numCourses;
        }

        public static void main(String[] argv) {
//            5
//[[1,4],[2,4],[3,1],[3,2]]
            System.out.println(new Solution2().canFinish(5, new int[][]{{1,4}, {2, 4}, {3, 1}, {3, 2}}));
        }
}
