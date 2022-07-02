package pro104;

public class Solution {
    public int maxDepth(TreeNode root) {
        int curDepth = 0;
        if(root == null) {
            return curDepth;
        }
        curDepth =1;
        int lDepth = curDepth;
        if(root.left != null) {
            lDepth = dfs(root.left, lDepth + 1);
        }
        int rDepth = curDepth;
        if(root.right != null) {
            rDepth = dfs(root.right, rDepth + 1);
        }
        return Integer.max(lDepth, rDepth);
    }

    public Integer dfs(TreeNode cur, Integer curDepth) {
        int lDepth = curDepth;
        if(cur.left != null) {
            lDepth = dfs(cur.left, lDepth + 1);
        }
        int rDepth = curDepth;
        if(cur.right != null) {
            rDepth = dfs(cur.right, rDepth + 1);
        }
        return Integer.max(lDepth, rDepth);
    }

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
}
