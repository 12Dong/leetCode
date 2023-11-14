package leetcode.pro124;

public class Solution4 {
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
 
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    static int ans = Integer.MIN_VALUE;

    public int dfs(TreeNode node) {
        int left = 0;
        if(node.left != null) {
            left = dfs(node.left);
        }
        int right = 0;
        if(node.right != null) {
            right = dfs(node.right);
        }
        ans = Math.max(ans, node.val + left + right);
        ans = Math.max(ans, node.val + left);
        ans = Math.max(ans, node.val + right);
        ans = Math.max(ans, node.val);
        int value = Math.max(node.val + left, node.val + right);
        value = Math.max(value, node.val);
        return value;
    }
}
