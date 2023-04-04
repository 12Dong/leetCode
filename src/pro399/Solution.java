package pro399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for(int i = 0; i < equationsSize;i ++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);

            if(!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }

            if(!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }

            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        double[] ans = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            if(!hashMap.containsKey(var1) || !hashMap.containsKey(var2)) {
                ans[i] = -1.0d;
            } else {
                ans[i] = unionFind.isConnected(hashMap.get(var1), hashMap.get(var2));
            }
        }

        return ans;
    }

    private class UnionFind {

        private int[] parent;

        /**
         * 指向的父结点的权值
         */
        private double[] weight;


        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            // 关系式的推导请见「参考代码」下方的示意图
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩
         *
         * @param x
         * @return 根结点的 id
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}
