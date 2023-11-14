package leetcode.pro104;

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
 
    public int maxDepth(TreeNode root) {
          if(root == null) {
              return 0;
          }
          int lDepth = 0;
          if(root.left != null) {
              lDepth = maxDepth(root.left);
          }
          int rDepth = 0;
          if(root.right != null) {
              rDepth = maxDepth(root.right);
          }
          return Math.max(lDepth, rDepth) + 1;
    }
}
