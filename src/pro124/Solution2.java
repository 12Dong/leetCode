package pro124;

public class Solution2 {

    public static int ans;

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

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        findMaxVal(root);
        return ans;
    }

    public int findMaxVal(TreeNode parent) {
         int lVal = Integer.MIN_VALUE;
         if(parent.left != null) {
             lVal = findMaxVal(parent.left);
         }
         int rVal = Integer.MIN_VALUE;
         if(parent.right != null) {
             rVal = findMaxVal(parent.right);
         }

         if(lVal >= 0 && rVal >= 0) {
             ans = Math.max(ans, parent.val + lVal + rVal);
             return parent.val + Math.max(lVal, rVal);
         } else if (lVal >= 0) {
             ans = Math.max(ans, parent.val + lVal);
             return parent.val + lVal;
         } else if (rVal >= 0) {
             ans = Math.max(ans, parent.val + rVal);
             return parent.val + rVal;
         } else {
             ans = Math.max(ans, parent.val);
             return parent.val;
         }
    }

    public static void main(String[] argv) {
         TreeNode l = new TreeNode(2);
         TreeNode r = new TreeNode(3);
         TreeNode root = new TreeNode(1, l, r);
         new Solution2().maxPathSum(root);
    }

}
