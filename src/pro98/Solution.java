package pro98;

public class Solution {

    public static boolean ans = false;
    public boolean isValidBST(TreeNode root) {

        ans = true;
        Pair lPair = root.left == null ? null : judge(root.left);
        Pair rPair = root.right == null ? null : judge(root.right);

        Pair curPair = new Pair();
        if(lPair == null) {
            curPair.min = root.val;
        } else {
            curPair.min = lPair.min;
        }

        if(rPair == null) {
            curPair.max = root.val;
        } else {
            curPair.max = rPair.max;
        }
        long lVal = lPair == null ? Long.MIN_VALUE : lPair.max;
        long rVal = rPair == null ? Long.MAX_VALUE : rPair.min;
        ans = ans && lVal < root.val && root.val < rVal;
        return ans;
    }

    public static Pair judge(TreeNode cur) {
//        boolean lResult = true;
//        if(cur.left != null) {
//            lResult = judge(cur.left);
//        }
//        boolean rResult = true;
//        if(cur.right != null) {
//            rResult = judge(cur.right);
//        }
//
//        int lVal = cur.left == null ? Integer.MIN_VALUE : cur.left.val;
//        int rVal = cur.right == null ? Integer.MAX_VALUE : cur.right.val;
//        boolean curResult = lVal < cur.val && cur.val < rVal;
//        return lResult && curResult && rResult;
        Pair lPair = cur.left == null ? null : judge(cur.left);
        Pair rPair = cur.right == null ? null : judge(cur.right);

        Pair curPair = new Pair();
        if(lPair == null) {
            curPair.min = cur.val;
        } else {
            curPair.min = lPair.min;
        }

        if(rPair == null) {
            curPair.max = cur.val;
        } else {
            curPair.max = rPair.max;
        }
        Long lVal = lPair == null ? Long.MIN_VALUE : lPair.max;
        Long rVal = rPair == null ? Long.MAX_VALUE : rPair.min;
        ans = ans && lVal < cur.val && cur.val < rVal;
        return curPair;
    }

    public static class Pair {
        int min;
        int max;
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
