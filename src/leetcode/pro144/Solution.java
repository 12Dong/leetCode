package leetcode.pro144;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }
        List<Integer> ans = new LinkedList<>();
        dfs(root, ans);
        return ans;
    }

    public void dfs(TreeNode cur, List<Integer> ans) {
          ans.add(cur.val);

          if(cur.left != null) {
              dfs(cur.left, ans);
          }

          if(cur.right != null) {
              dfs(cur.right, ans);
          }
    }
}
