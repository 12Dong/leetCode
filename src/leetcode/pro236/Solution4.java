package leetcode.pro236;

public class Solution4 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
          } else if(l != null || r != null) {
              if(root == l || root == r) {
                  return root;
              } else {
                  return l != null ? l : r;
              }
          } else {
              if(root == p || root == q) {
                  return root;
              } else {
                  return null;
              }
          }
    }
}
