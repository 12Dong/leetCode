package leetcode.pro94;

import java.util.LinkedList;
import java.util.List;

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
 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        dfs(ans, root);
        return ans;
      }

    public void dfs(List<Integer> ans, TreeNode node) {
          if(node.left != null) {
              dfs(ans, node.left);
          }
          ans.add(node.val);
          if(node.right != null) {
              dfs(ans, node.right);
          }
    }
}
