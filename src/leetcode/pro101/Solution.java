package leetcode.pro101;

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

    public boolean isSymmetric(TreeNode root) {
          if(root == null) {
              return true;
          }
        return compare(root.left, root.right);
    }

    public static Boolean compare(TreeNode node, TreeNode comp) {
        if(node == null && comp == null) {
            return true;
        } else if(node != null && comp != null) {
            if(node.val == comp.val) {
                Boolean left = compare(node.right, comp.left);
                Boolean right = compare(node.left, comp.right);
                return left && right;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
