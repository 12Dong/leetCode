package leetcode.pro98;

public class Solution2 {
    
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
 
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long low, long up) {
        if(root == null) {
            return true;
        }
        if(!(root.val >= low && root.val <= up)) {
            return false;
        }
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, up);
    }

    public static void main(String[] argv) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode5.left = treeNode1;
        treeNode5.right =  treeNode4;
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode6;
        new Solution2().isValidBST(treeNode5);
    }
}
