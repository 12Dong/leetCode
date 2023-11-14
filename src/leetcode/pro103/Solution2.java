package leetcode.pro103;

import java.util.*;

public class Solution2 {
    
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
          if(root == null) {
              return new LinkedList<>();
          }
        List<List<Integer>> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        boolean sign = true;
        while(!stack.isEmpty()) {
            List<Integer> layer = new LinkedList<>();
            Stack<TreeNode> nextS = new Stack<>();
            while(stack.size() != 0) {
                TreeNode cur = stack.pop();
                layer.add(cur.val);
                if(sign) {
                    if(cur.left != null) {
                        nextS.add(cur.left);
                    }
                    if(cur.right != null) {
                        nextS.add(cur.right);
                    }


                } else {
                    if(cur.right != null) {
                        nextS.add(cur.right);
                    }
                    if(cur.left != null) {
                        nextS.add(cur.left);
                    }
                }
            }
            sign = !sign;
            stack = nextS;
            ans.add(layer);
        }
        return ans;
    }
}
