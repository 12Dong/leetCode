package leetcode.pro437;

import java.util.*;

public class Solution {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode() {
          }

          TreeNode(int val) {
              this.val = val;
          }

          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        Map<TreeNode, Long> preSum = new HashMap<>();
        ans = 0;
        makePreSum(null, root, preSum, targetSum);

        dfs(root, preSum, targetSum);
        return ans;
    }

    public static void makePreSum(final TreeNode parent, final TreeNode cur, Map<TreeNode, Long> map, int targetSum) {

        if(parent == null) {
            map.put(cur, map.getOrDefault(cur, 0L) + cur.val);
            if(map.get(cur) == targetSum) ans++;
        } else {
            map.put(cur, map.getOrDefault(parent, 0L) + cur.val);
            if(map.get(cur) == targetSum) ans++;
        }

        if(cur.left != null) {
            makePreSum(cur, cur.left, map, targetSum);
        }

        if(cur.right != null) {
            makePreSum(cur, cur.right, map, targetSum);
        }
    }

    static int ans = 0;

    public static void dfs(TreeNode src, Map<TreeNode, Long> map, int targetSum) {
        if(src.left != null) {
            dfs(src, src.left, map, targetSum);
            dfs(src.left, map, targetSum);
        }

        if(src.right != null) {
            dfs(src, src.right, map, targetSum);
            dfs(src.right, map, targetSum);
        }
    }

    public static void dfs(TreeNode src, TreeNode cur, Map<TreeNode, Long> map, int targetSum) {
        if(map.get(cur) - map.get(src) == targetSum) {
            ans++;
        }
        if(cur.left != null) {
            dfs(src, cur.left, map, targetSum);
        }
        if(cur.right != null) {
            dfs(src, cur.right, map, targetSum);
        }

    }

    public static void main(String[] argv) {
//        TreeNode node3 = new TreeNode(3, null, null);
//        TreeNode nodef2 = new TreeNode(-2, null, null);
//        TreeNode nodep3 = new TreeNode(3, node3, nodef2);
//        TreeNode node1 = new TreeNode(1, null, null);
//        TreeNode node2 = new TreeNode(2, null, node1);
//        TreeNode node5 = new TreeNode(5, nodep3, node2);
//        TreeNode node11 = new TreeNode(11, null, null);
//        TreeNode nodeaf3 = new TreeNode(-3, null, node11);
//        TreeNode root = new TreeNode(10, node5, nodeaf3);
//        [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
//        0
        TreeNode t7 = new TreeNode(1000000000, null, null);
        TreeNode t6 = new TreeNode(1000000000, t7, null);
        TreeNode t5 = new TreeNode(1000000000, t6, null);
        TreeNode t4 = new TreeNode(1000000000, t5, null);
        TreeNode t3 = new TreeNode(294967296, t4, null);
        TreeNode t2 = new TreeNode(1000000000, t3, null);
        TreeNode t1 = new TreeNode(1000000000, t2, null);
        System.out.println(new Solution().pathSum(t1, 0));
    }


}
