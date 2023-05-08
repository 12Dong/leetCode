package leetcode.pro958;

import java.util.LinkedList;
import java.util.Queue;

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

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Boolean sign = true;
        while(!q.isEmpty()) {
            Queue<TreeNode> tmp = new LinkedList<>();
            while(!q.isEmpty()) {
                TreeNode cur = q.poll();
                if(cur.left != null && sign) {
                    tmp.add(cur.left);
                } else if(cur.left != null && sign == false) {
                    return false;
                } else {
                    sign = false;
                }
                if(cur.right != null && sign) {
                    tmp.add(cur.right);
                } else if(cur.right != null && sign == false) {
                    return false;
                } else {
                    sign = false;
                }
            }
            q = tmp;
        }
        return true;

    }
}
