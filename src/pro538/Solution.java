package pro538;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        sum = 0;
        sum(root);
        return root;
    }
    public static void sum(TreeNode cur) {

        if(cur.right != null) {
            sum(cur.right);
        }
        sum += cur.val;
        cur.val = sum;
        if(cur.left != null) {
            sum(cur.left);
        }
    }
}
