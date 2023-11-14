package leetcode.pro199;

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
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }
        List<Integer> ans = new LinkedList<>();
        maxLayer = 0;
        dfs(ans, root, 1);
        return ans;
    }

    static int maxLayer = 0;

    public void dfs(List<Integer> ans, TreeNode node, int currentLayer) {
        if(currentLayer > maxLayer) {
            ans.add(node.val);
            maxLayer++;
        }
        if(node.right != null) {
            dfs(ans, node.right, currentLayer + 1);
        }
        if(node.left != null) {
            dfs(ans, node.left, currentLayer + 1);
        }
    }
}
