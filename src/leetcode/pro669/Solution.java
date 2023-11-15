package leetcode.pro669;

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
    
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root.left != null) {
            root.left = trimBST(root.left, low, high);
        }

        if(root.right != null) {
            root.right = trimBST(root.right, low, high);
        }

        if(root.val < low) {
            return root.right;
        } else if(root.val <= high) {
            return root;
        } else {
            return root.left;
        }
    }
}
