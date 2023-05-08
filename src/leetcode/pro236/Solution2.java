package leetcode.pro236;

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return root;

        if(root.val == p.val || root.val == q.val) {
            return root;
        }

//        Boolean l = false;
//        if(root.left !=null) {
//            if(root.left.val == p.val || root.left.val == q.val) {
//                l = true;
//            }
//        }
//
//        Boolean r = false;
//        if(root.right != null) {
//            if(root.right.val == p.val || root.right.val == q.val) {
//                r = true;
//            }
//        }
//
//        if(l || r) {
//            return root;
//        }


        TreeNode left = null;
        if(root.left != null) {
            left = lowestCommonAncestor(root.left, p, q);
        }
        TreeNode right = null;
        if(root.right != null) {
            right = lowestCommonAncestor(root.right, p, q);
        }

        if(left != null && right != null) {
            return root;
        } else if(left != null) {
            return left;
        } else if(right != null) {
            return right;
        } {
            return null;
        }

    }
    
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
