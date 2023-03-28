package pro617;

public class Solution {
    
      public static class TreeNode {
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        merge(root1, root2);
        return root1;
    }

    public void merge(TreeNode node1, TreeNode node2) {
          node1.val += node2.val;
          if(node1.left == null || node2.left == null) {
              node1.left = node1.left == null ? node2.left : node1.left;
          } else {
              merge(node1.left, node2.left);
          }
          if(node1.right == null || node2.right == null) {
              node1.right = node1.right == null ? node2.right : node1.right;
          } else {
              merge(node1.right, node2.right);
          }
    }
}
