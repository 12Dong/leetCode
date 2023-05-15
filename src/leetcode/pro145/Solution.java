package leetcode.pro145;

import java.util.LinkedList;
import java.util.List;

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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        dfs(root, ans);
        return ans;
    }

    public void dfs(TreeNode cur, List<Integer> ans) {
          if(cur.left != null) {
              dfs(cur.left, ans);
          }

          if(cur.right != null) {
              dfs(cur.right, ans);
          }

          ans.add(cur.val);
    }
}
