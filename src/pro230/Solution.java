package pro230;

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
    
    public int kthSmallest(TreeNode root, int k) {
        ans = -1;
        dfs(root, k);
        return ans;
    }

    public static int ans = -1;

    public int dfs(TreeNode cur, int k) {
        int left = 0;
        if(cur.left != null) {
            left = dfs(cur.left, k);
        }

        if(left + 1 == k && ans == -1) {
            ans = cur.val;
        }

        int right = 0;
        if(cur.right != null) {
            right = dfs(cur.right, k - left - 1);
        }

        return left + 1 + right;
    }
}
