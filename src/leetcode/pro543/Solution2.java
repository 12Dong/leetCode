package leetcode.pro543;

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


    public int diameterOfBinaryTree(TreeNode root) {
          ans = 0;
          dfs(root);
          return ans;
    }

    static int ans = 0;

    public int dfs(TreeNode root) {
        int lDepth = 0;
        if(root.left != null) {
            lDepth = dfs(root.left);
        }
        int rDepth = 0;
        if(root.right != null) {
            rDepth = dfs(root.right);
        }
        ans = Math.max(lDepth + rDepth, ans);
        return Math.max(lDepth, rDepth) + 1;
    }

    public static void main(String[] argv) {
          TreeNode node1 = new TreeNode(1);
          TreeNode node2 = new TreeNode(2);
          node1.left = node2;
          new Solution2().diameterOfBinaryTree(node1);
    }
}
