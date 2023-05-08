package leetcode.pro114;

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

    public void flatten(TreeNode root) {
        if(root == null) return;
        change(root);
    }

    public TreeNode change(TreeNode node) {
          TreeNode left = node.left;
          if(left != null) {
              left = change(left);
          }
          TreeNode right = node.right;
          if(right != null) {
              right = change(node.right);
          }

          if(left != null) {
             TreeNode tmp = node.right;
             node.right = node.left;
             left.right = tmp;
             node.left = null;
          }

          if(right != null) {
              return right;
          } else if(left != null){
              return left;
          } else {
              return node;
          }
      }
}
