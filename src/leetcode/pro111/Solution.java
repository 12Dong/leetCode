package leetcode.pro111;

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
    
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        ans = Integer.MAX_VALUE;
        dfs(root, 0);
        return ans;
    }

    public static int ans = Integer.MAX_VALUE;

    public void dfs(TreeNode cur, int depth) {
        if(cur.left == null && cur.right == null) {
            ans = Math.min(ans, depth + 1);
            return;
        }
        if(cur.left != null) {
            dfs(cur.left, depth + 1);
        }

        if(cur.right != null) {
            dfs(cur.right, depth + 1);
        }
    }

}
