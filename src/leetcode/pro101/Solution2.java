package leetcode.pro101;

public class Solution2 {
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode node, TreeNode compare) {
          if(node == null && compare == null) {
              return true;
          }
          if(node == null || compare == null) {
              return false;
          }
          if(node.val != compare.val) {
              return false;
          }
          boolean flag1 = isSymmetric(node.left, compare.right);
          boolean flag2 = isSymmetric(node.right, compare.left);
          return flag1 && flag2;
    }
}
