package leetcode.pro572;

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

    TreeNode sourceRoot;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        } else if(root != null && subRoot == null) {
            return false;
        } else if(root == null && subRoot != null) {
            return false;
        }
        return checkSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean checkSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        } else if(root != null && subRoot == null) {
            return false;
        } else if(root == null && subRoot != null) {
            return false;
        } else {
            if(root.val == subRoot.val) {
                return checkSameTree(root.left, subRoot.left) && checkSameTree(root.right, subRoot.right);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] argv) {
        TreeNode node3 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1, null, node3);
        TreeNode node1 = new TreeNode(1, null, node2);
        System.out.println(new Solution().isSubtree(node1, node2));
    }
}
