package leetcode.pro129;

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

    public int sumNumbers(TreeNode root) {
        sum = 0L;
        dfs(root, 0L);
        return sum.intValue();
    }

    static Long sum = 0L;

    public void dfs(TreeNode cur, Long curValue) {
        if(cur.left == null && cur.right == null) {
            sum += (curValue + cur.val);
        }

        if(cur.left != null) {
            dfs(cur.left, (curValue + cur.val) * 10);
        }

        if(cur.right != null) {
            dfs(cur.right, (curValue + cur.val) * 10);
        }

    }
}
