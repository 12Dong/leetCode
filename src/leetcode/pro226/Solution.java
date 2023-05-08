package leetcode.pro226;

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

    public TreeNode invertTree(TreeNode root) {

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left != null) {
            invertTree(root.left);
        }

        if(root.right != null) {
            invertTree(root.right);
        }

        return root;
    }

}
