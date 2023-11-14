package leetcode.pro114;

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

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root);
    }

    public TreeNode dfs(TreeNode node) {

          TreeNode returnNode = node;
          TreeNode leftNode = null;
          if(node.left != null) {

              leftNode = returnNode = dfs(node.left);
          }

          if(node.right != null) {
              returnNode = dfs(node.right);
          }
          if(leftNode != null) {
              leftNode.right = node.right;
              node.right = node.left;
              node.left = null;
          }

          return returnNode;
    }
}
