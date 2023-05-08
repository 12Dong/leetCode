package leetcode.pro662;

public class Solution {
    
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

    public int widthOfBinaryTree(TreeNode root) {
        levels = new int[3002][2];
        int ans = 0;
        for(int i = 0; i < 3002; i++) {
            levels[i][0] = Integer.MAX_VALUE;
            levels[i][1] = Integer.MIN_VALUE;
        }
        dfs(root, 0, 0);
        for(int i = 0; i < 3002; i++) {
            if(levels[i][0] == Integer.MAX_VALUE) break;
            ans = Math.max(ans, levels[i][1] - levels[i][0]);
        }
        return ans + 1;
    }

    int[][] levels = new int[3002][2];

    public void dfs(TreeNode cur, int value, int level) {
        levels[level][0] = Math.min(levels[level][0], value);
        levels[level][1] = Math.max(levels[level][1], value);
        if(cur.left != null) {
            dfs(cur.left, value * 2 + 1, level + 1);
        }
        if(cur.right != null) {
            dfs(cur.right, value * 2 + 2, level + 1);
        }
    }

    public static void main(String[] argv) {
        TreeNode root = new TreeNode(1);
        new Solution().widthOfBinaryTree(root);
    }
}
