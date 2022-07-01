package pro94;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        if(root.left != null) {
            leftFirst(ans, root.left);
        }
        ans.add(root.val);
        if(root.right != null) {
            leftFirst(ans, root.right);
        }
        return ans;
    }

    public void leftFirst(List<Integer> ans, TreeNode cur) {
        if(cur.left != null) {
            leftFirst(ans, cur.left);
        }
        ans.add(cur.val);
        if(cur.right != null) {
            leftFirst(ans, cur.right);
        }
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
