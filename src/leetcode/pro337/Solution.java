package leetcode.pro337;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public int rob(TreeNode root) {
          if(root == null) return 0;
          // key 是 node 的 hash value
        // [0] 没有打劫
        // [1] 打劫了 的最大值
        Map<Integer, int[]> map = new HashMap<>();
        dfs(root, map);
        return Math.max(map.get(root.hashCode())[0], map.get(root.hashCode())[1]);
    }


    public void dfs(TreeNode node, Map<Integer, int[]> map) {

          if(node == null) return;

          if(node.left != null) {
              dfs(node.left, map);
          }

          if(node.right != null) {
              dfs(node.right, map);
          }

          int[] value = new int[2];
          int lV = node.left != null ? Math.max(map.get(node.left.hashCode())[0], map.get(node.left.hashCode())[1]) : 0;
          int rV = node.right != null ? Math.max(map.get(node.right.hashCode())[0], map.get(node.right.hashCode())[1]) : 0;
          value[0] = lV + rV;
          lV = node.left != null ? map.get(node.left.hashCode())[0] : 0;
          rV = node.right != null ? map.get(node.right.hashCode())[0] : 0;
          value[1] = lV + rV + node.val;
          map.put(node.hashCode(), value);
    }


    public static void main(String[] argv) {
          TreeNode t1 = new TreeNode(1, null, null);
          TreeNode t2 = new TreeNode(2, null, t1);
          TreeNode t3 = new TreeNode(3, null, t2);
          System.out.println(new Solution().rob(t3));
    }
}
