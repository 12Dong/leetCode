package leetcode.pro404;

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
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    public int dfs(TreeNode cur, boolean left) {
          if(cur.left == null && cur.right == null && left) {
              return cur.val;
          }

          int leftV = 0;
          if(cur.left != null) {
              leftV =  dfs(cur.left, true);
          }

          int rightV = 0;
          if(cur.right != null) {
              rightV = dfs(cur.right, false);
          }
          return leftV + rightV;
    }
//   5
//    [0,2,4,1,null,3,-1,5,1,null,6,null,8]

//    0
//    2 4
//    1 null 3 -1
//    5 1 null null null 6 null 8

}
