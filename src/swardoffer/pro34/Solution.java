package swardoffer.pro34;

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
  }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> ans = new LinkedList<>();
        dfs(root, ans, new LinkedList<>(), 0, target);
        return ans;
    }

    public void dfs(TreeNode cur, List<List<Integer>> ans, List<Integer> curList, int sum, int target) {
          if(cur.left == null && cur.right == null) {
              if(sum + cur.val == target) {
                  curList.add(cur.val);
                  ans.add(new LinkedList<>(curList));
                  curList.remove(curList.size() - 1);
              }
              return;
          }

          if(cur.left != null) {
              curList.add(cur.val);
              dfs(cur.left, ans, curList, sum + cur.val, target);
              curList.remove(curList.size() - 1);
          }

          if(cur.right != null) {
              curList.add(cur.val);
              dfs(cur.right, ans, curList, sum + cur.val, target);
              curList.remove(curList.size() - 1);
          }
    }
}
