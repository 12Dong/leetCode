package swardoffer.pro54;

public class Solution {
    
    
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static int ans = -1;

    public int kthLargest(TreeNode root, int k) {
        ans = -1;
        dfs(root, k);
        return ans;
    }

    public int dfs(TreeNode cur, int k) {
        int right = 0;
        if(cur.right != null) {
            right = dfs(cur.right, k);
        }

        if(ans != -1) {
            return 0;
        }

        if(k == right + 1) {
            ans = cur.val;
            return 0;
        }

        int left = 0;
        if(cur.left != null) {
            left = dfs(cur.left, k - 1 - right);
        }
        return left + 1 + right;
    }
}
