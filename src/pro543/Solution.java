package pro543;

class Solution {

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

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null ) {
            return 0;
        }
        depth = 0;
        int l = 0;
        if(root.left != null) {
            dfs(root.left, 1);
            l = depth;
        }
        depth = 0;
        int r = 0;
        if(root.right != null) {
            dfs(root.right, 1);
            r = depth;
        }
        return l + r;
    }

    public static int depth;
    public static void dfs(TreeNode node, int curD) {
        if(node.left == null && node.right == null) {
            depth = Math.max(curD, depth);
            return;
        }
        if(node.left != null) {
            dfs(node.left, curD + 1);
        }
        if(node.right != null) {
            dfs(node.right, curD + 1);
        }
    }
}

/**
 * [4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
 */
/**
   4
 -7  -3
n n -9 -3
nn nn 9 -7 -4 null
nnnn nnnn 6 n -6 -6 nn nn
         n n nn 0 6 5 n
               9n n-1 -4n

 **/