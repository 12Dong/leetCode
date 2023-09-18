package leetcode.pro236;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          if(root == p || root == q) {
              return root;
          }
          TreeNode l = null;
          if(root.left != null) {
              l = lowestCommonAncestor(root.left, p, q);
          }
          TreeNode r = null;
          if(root.right != null) {
              r = lowestCommonAncestor(root.right, p, q);
          }

          if(l != null && r != null) {
              return root;
          } else if(l != null) {
              return l;
          } else if(r != null) {
              return r;
          } else {
              return null;
          }

    }

}
