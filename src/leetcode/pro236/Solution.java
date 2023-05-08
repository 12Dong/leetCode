package leetcode.pro236;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q) return root;
        TreeNode left = root.left == null ? null : lowestCommonAncestor(root.left, p, q);
        TreeNode right = root.right == null ? null : lowestCommonAncestor(root.right, p, q);
        if(left == null) {
            return right;
        } else if(right == null) {
            return left;
        }
        return root;
    }

    
       public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
