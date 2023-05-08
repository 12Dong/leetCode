package leetcode.pro207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjacency = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for(int[] prerequisty : prerequisites) {
            int end = prerequisty[0];
            int start = prerequisty[1];
            indegree[end]++;
            adjacency.get(start).add(end);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int start = 0; start < numCourses; start++) {
            if(indegree[start] == 0) {
                queue.add(start);
            }
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            numCourses--;
            for(int end : adjacency.get(cur)) {
                indegree[end]--;
                if(indegree[end] == 0) {
                    queue.add(end);
                }
            }
        }

        return numCourses == 0;
    }
}
