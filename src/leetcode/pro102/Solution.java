package leetcode.pro102;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    
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
 
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        List<TreeNode> cur = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        cur.add(root);
        dfs(cur, ans);
        return ans;
    }

    public void dfs(List<TreeNode> cur, List<List<Integer>> ans) {
        List<TreeNode> next = new LinkedList<>();
        List<Integer> curVal = new LinkedList<>();
        for(TreeNode curNode : cur) {
            curVal.add(curNode.val);
            if(curNode.left != null) {
                next.add(curNode.left);
            }
            if(curNode.right != null) {
                next.add(curNode.right);
            }
        }
        ans.add(curVal);
        if(!next.isEmpty()) {
            dfs(next, ans);
        }
    }

      }
}
