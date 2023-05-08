package leetcode.pro124;

public class Solution {

    public static Integer ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        int lVal = 0;
        if(root.left != null) {
            lVal = dfs(root.left);
        }
        int rVal = 0;
        if(root.right != null) {
            rVal = dfs(root.right);
        }
        int curVal = root.val;

        if(lVal >= 0 && rVal >= 0) {
            ans = Integer.max(ans, curVal + lVal + rVal);
        } else if(lVal >= 0) {
            ans = Integer.max(ans ,curVal + lVal);
        } else if(rVal >= 0) {
            ans = Integer.max(ans ,curVal + rVal);
        } else {
            ans = Integer.max(ans, curVal);
        }
        return ans;
    }

    public int dfs(TreeNode cur) {
        int lVal = 0;
        if(cur.left != null) {
            lVal = dfs(cur.left);
        }
        int rVal = 0;
        if(cur.right != null) {
            rVal = dfs(cur.right);
        }
        int curVal = cur.val;

        if(lVal >= 0 && rVal >= 0) {
            ans = Integer.max(ans, curVal + lVal + rVal);
            return curVal + Integer.max(lVal, rVal);
        } else if(lVal >= 0) {
            ans = Integer.max(ans ,curVal + lVal);
            return curVal + lVal;
        } else if(rVal >= 0) {
            ans = Integer.max(ans ,curVal + rVal);
            return curVal + rVal;
        } else {
            ans = Integer.max(ans, curVal);
            return curVal;
        }


    }
    
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
}
