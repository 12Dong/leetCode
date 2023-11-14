package leetcode.pro230;

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
 
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k, 0);
        return ans;
    }

    static int ans = -1;

    public int dfs(TreeNode node, int k, int less) {

          int lless = 0;
          if(node.left != null) {
              lless = dfs(node.left, k, less);
          }
          int rless = 0;
          if(less + lless + 1 == k) {
              ans = node.val;
          }
          if(node.right != null) {
              rless = dfs(node.right, k, less + lless + 1);
          }
          return lless + 1 + rless;
    }
}
