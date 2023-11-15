package leetcode.pro235;

public class Solution {
    
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        find(root, p, q);
        return ans;
    }

    static TreeNode ans;

    public boolean find(TreeNode cur, TreeNode p, TreeNode q) {
          boolean flagL = false;
          if(cur.left != null) {
            flagL = find(cur.left, p, q);
          }

          boolean flagR = false;
          if(cur.right != null) {
              flagR = find(cur.right, p, q);
          }

          if(flagL && flagR) {
              ans = cur;
              return true;
          } else if(flagL || flagR) {
              if(cur == p || cur == q) {
                  ans = cur;
              }
              return true;
          } else if(cur == p || cur == q) {
              return true;
            }
          return false;
    }
}
