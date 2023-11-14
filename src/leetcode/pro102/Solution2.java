package leetcode.pro102;

import java.util.LinkedList;
import java.util.List;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        List<List<Integer>> ans = new LinkedList<>();
        while(!list.isEmpty()) {
            int size = list.size();
            List<Integer> layer = new LinkedList<>();
            while(size != 0) {
                TreeNode cur = list.remove(0);
                layer.add(cur.val);
                if(cur.left != null) {
                    list.add(cur.left);
                }
                if(cur.right != null) {
                    list.add(cur.right);
                }
                size--;
            }
            ans.add(layer);
        }
        return ans;
    }
}
