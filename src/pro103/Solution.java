package pro103;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
          if(root == null) return new LinkedList<>();
          List<List<Integer>> ans = new LinkedList<>();
          ans.add(Arrays.asList(root.val));
        Stack<TreeNode> stack = new Stack<>();
        boolean sign = false;
        stack.add(root);
        while(!stack.isEmpty()) {
            List<TreeNode> process = new LinkedList<>();
            while(!stack.isEmpty()) {
                process.add(stack.pop());
            }
            List<Integer> val = new LinkedList<>();
            if(sign) {
                while(!process.isEmpty()) {
                    TreeNode cur = process.remove(0);
                    if(cur.left != null) {
                        val.add(cur.left.val);
                        stack.add(cur.left);
                    }
                    if(cur.right != null) {
                        val.add(cur.right.val);
                        stack.add(cur.right);
                    }

                }
            } else {
                while(!process.isEmpty()) {
                    TreeNode cur = process.remove(0);
                    if(cur.right != null) {
                        val.add(cur.right.val);
                        stack.add(cur.right);
                    }
                    if(cur.left != null) {
                        val.add(cur.left.val);
                        stack.add(cur.left);
                    }
                }
            }
            if(val.size() > 0) ans.add(val);
            sign = !sign;
        }
        return ans;
    }
}
