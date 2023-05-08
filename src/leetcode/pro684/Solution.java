package leetcode.pro684;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        int id = 0;
        UnionFind unionFind = new UnionFind(edges.length * 2);
        int[] ans = new int[2];
        for(int[] edge : edges) {
            int point1 = edge[0];
            int point2 = edge[1];
            if(!map.containsKey(point1)) {
                map.put(point1, id);
                id++;
            }
            if(!map.containsKey(point2)) {
                map.put(point2, id);
                id++;
            }
            if(unionFind.find(map.get(point1)) == unionFind.find(map.get(point2))) {
                ans[0] = edge[0];
                ans[1] = edge[1];
            }
            unionFind.union(map.get(point1), map.get(point2));
        }
        return ans;
    }

    public class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if(rootx == rooty) {
                return;
            } else {
                parent[rootx] = rooty;
            }
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
