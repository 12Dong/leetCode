package leetcode.pro107;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    
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
 
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> aans = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                aans.add(cur.val);
                if(cur.left != null) {
                    queue.add(cur.left);
                }

                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            ans.addFirst(aans);
        }
        return new LinkedList<>(ans);
    }
}
