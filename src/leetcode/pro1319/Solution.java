package leetcode.pro1319;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        Map<Integer, Integer> map = new HashMap<>();
        int id = 0;
        int rest = 0;
        for(int[] connection : connections) {
            int point1 = connection[0];
            int point2 = connection[1];

            if(!map.containsKey(point1)) {
                map.put(point1, id++);
            }

            if(!map.containsKey(point2)) {
                map.put(point2, id++);
            }

            if(unionFind.find(map.get(point1)) == unionFind.find(map.get(point2))) {
                rest++;
            }
            unionFind.union(map.get(point1), map.get(point2));
        }

        int check = unionFind.check();
        int need = check - 1;
        if(check == 1) {
            return 0;
        } else if(need <= rest) {
            return need;
        } else {
            return -1;
        }
    }

    public class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if(rootx != rooty) {
                parent[rootx] = rooty;
            }
        }

        public int check() {
            int count = 0;
            for(int i = 0; i < parent.length; i++) {
                if(i == parent[i]) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] argv) {
//        int[][] connections = new int[][]{{0,1},{0,2},{3,4},{2,3}};
        int[][] connections = new int[][]{{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},
                {0,4},{2,6},{0,3},{0,2}};
        new Solution().makeConnected(12, connections);
    }
}
