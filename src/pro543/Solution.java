package pro543;

class Solution {

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


    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public static int ans = 0;

    public static int dfs(TreeNode node) {
        if(node.left == null && node.right == null) {
            return 1;
        }
        int left = 0;
        if(node.left != null) {
            left = dfs(node.left);
        }
        int right = 0;
        if(node.right != null) {
            right = dfs(node.right);
        }

        if(left != 0 && right != 0) {
            ans = Math.max(ans, left + right;
        } else if(left == 0) {
            ans = Math.max(ans, right);
        } else if(right == 0) {
            ans = Math.max(ans, left);
        }
        return Math.max(left, right) + 1;
    }
}