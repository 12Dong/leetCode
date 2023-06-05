package leetcode.pro863;

import java.util.*;

public class Solution {
    
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Arrays.fill(he, -1);
        Arrays.fill(vis, false);
        index = 0;
        dfs(root);
        Deque<Integer> q = new LinkedList<>();
        vis[target.val] = true;
        q.add(target.val);
        while(!q.isEmpty() && k > 0) {
            int size = q.size();
            while(size > 0 && k > 0) {
                int from = q.pop();
                for(int e = he[from]; e != -1; e = toPoints[e]) {
                    int to = edge[e];
                    if(!vis[to]) {
                        q.add(to);
                        vis[to] = true;
                    }
                }
                size--;
            }
            k--;
        }
        List<Integer> ans = new LinkedList<>();
        while(!q.isEmpty()) {
            ans.add(q.pop());
        }
        return ans;
    }

    static int N = 505;
    static int M = N * 4;
    static int index = 0;
    static int[] edge = new int[M];
    static int[] toPoints = new int[M];
    static int[] he = new int[M];

    static boolean[] vis = new boolean[N];

    public void dfs(TreeNode node) {
        if(node.left != null) {
            add(node.val, node.left.val);
            add(node.left.val, node.val);
            dfs(node.left);
        }

        if(node.right != null) {
            add(node.val, node.right.val);
            add(node.right.val, node.val);
            dfs(node.right);
        }
    }

    public static void add(int from, int to) {
        edge[index]  = to;
        toPoints[index] = he[from];
        he[from] = index++;
    }
}
