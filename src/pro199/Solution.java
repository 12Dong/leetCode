package pro199;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    
      static public class TreeNode {
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

  public class TreeNodeWithLayer {
          public TreeNode treeNode;
          public Integer layer;
          public TreeNodeWithLayer(TreeNode treeNode, Integer layer) {
              this.treeNode = treeNode;
              this.layer = layer;
          }
  }

  public static Integer layer = 0;

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new LinkedList<>();
        layer = 0;
          List<Integer> ans = new LinkedList<>();
        dfs(new TreeNodeWithLayer(root, 1), ans);
        return ans;
      }

      public void dfs(TreeNodeWithLayer treeNodeWithLayer, List<Integer> ans) {
        if(treeNodeWithLayer.layer -1 == layer) {
            ans.add(treeNodeWithLayer.treeNode.val);
            layer++;
        }
        if(treeNodeWithLayer.treeNode.right != null) {
            dfs(new TreeNodeWithLayer(treeNodeWithLayer.treeNode.right, treeNodeWithLayer.layer + 1), ans);
        }
        if(treeNodeWithLayer.treeNode.left != null) {
            dfs(new TreeNodeWithLayer(treeNodeWithLayer.treeNode.left, treeNodeWithLayer.layer + 1), ans);
        }
      }

      public static void main(String[] argv) {
//          TreeNode n5 = new TreeNode(5);
//          TreeNode n2 = new TreeNode(2, null, n5);
//          TreeNode n4 = new TreeNode(4);
//          TreeNode n3 = new TreeNode(3, null ,n4);
//          TreeNode n1 = new TreeNode(1, n2, n3);
                    TreeNode n3 = new TreeNode(3, null ,null);
          TreeNode n1 = new TreeNode(1, null, n3);
          new Solution().rightSideView(n1);
      }
}
