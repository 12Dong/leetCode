package leetcode.pro124;

public class Solution3 {
    
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
 
    static int ans = 0;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        findMax(root);
        return ans;
    }

    public int findMax(TreeNode cur) {
        int left = 0;
        if(cur.left != null) {
            left = findMax(cur.left);
        }

        int right = 0;
        if(cur.right != null) {
            right = findMax(cur.right);
        }

        if(left > 0 && right > 0) {
            ans = Math.max(ans, left + cur.val + right);
        } else if(left <= 0 && right <= 0) {
            ans = Math.max(ans, cur.val);
        } else if(left <= 0){
            ans = Math.max(ans, cur.val + right);
        } else if(right <= 0){
            ans = Math.max(ans, cur.val + left);
        }
        int result = cur.val;
        result = Math.max(result, cur.val + right);
        result = Math.max(result, cur.val + left);
        return result;
    }
}
