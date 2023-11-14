package leetcode.pro437;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    
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

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        ans = 0;
        Map<Long, Integer> cntMap = new HashMap<>();
        cntMap.put(0l, 1);
        pathSum(root, targetSum, 0l, cntMap);
        return ans;
    }

    static int ans = 0;

    public void pathSum(TreeNode node, int targetSum , Long prefixSum, Map<Long, Integer> cntMap) {
        prefixSum += node.val;
        if(cntMap.containsKey(prefixSum - targetSum)) {
            ans += cntMap.get(prefixSum - targetSum);
        }
        if(node.val == 7 || node.val == 2 || node.val == 5 ) {
            int i = 1;
        }
        cntMap.put(prefixSum, cntMap.getOrDefault(prefixSum, 0) + 1);
        if(node.left != null) {
            pathSum(node.left, targetSum, prefixSum, cntMap);
        }
        if(node.right != null) {
            pathSum(node.right, targetSum, prefixSum, cntMap);
        }
        cntMap.put(prefixSum, cntMap.getOrDefault(prefixSum, 0) - 1);
    }

    public static void main(String[] argv) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node44 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node55 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13;
        node8.right = node44;
        node44.left = node55;
        node44.right = node1;
        new Solution2().pathSum(node5, 22);
    }
}
