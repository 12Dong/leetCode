package swardoffer.pro27;

public class Solution {
    
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) {
            return root;
        }        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left != null) {
            mirrorTree(root.left);
        }

        if(root.right != null) {
            mirrorTree(root.right);
        }
        return root;
    }
}
