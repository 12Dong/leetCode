package pro110;

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

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        result = true;
        dfs(root);
        return result;
    }

    public static boolean result = true;

    public int dfs(TreeNode cur) {
          if(cur.left == null && cur.right == null) {
              return 1;
          }
          int left = 0;
          if(cur.left != null) {
              left = dfs(cur.left);
          }

          int right = 0;
          if(cur.right != null) {
              right = dfs(cur.right);
          }
          if(Math.abs(left - right) > 1) {
              result = false;
          }
          return Math.max(left, right) + 1;
    }
}
