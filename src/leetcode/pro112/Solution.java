package leetcode.pro112;

public class Solution {
    
      public class TreeNode {
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
          if(root == null) {
              return false;
          }
          return find(root, 0, targetSum);
    }

    public static Boolean find(TreeNode curNode, int curValue, int target) {
          if(curNode.left == null && curNode.right == null) {
              return curValue + curNode.val == target;
          }
          if(curNode.left != null) {
              Boolean tmp = find(curNode.left, curValue + curNode.val, target);
              if(tmp) {
                  return true;
              }
          }
          if(curNode.right != null) {
              return find(curNode.right, curValue + curNode.val, target);
          }
          return false;
    }
}
