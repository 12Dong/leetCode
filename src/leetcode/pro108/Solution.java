package leetcode.pro108;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length -1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start > end || start < 0 || end >= nums.length) {
            return null;
        }
        if(start == end) {
            TreeNode treeNode = new TreeNode(nums[start]);
            return treeNode;
        }
        int middle = (start + end) / 2;
        TreeNode treeNode = new TreeNode();
        treeNode.val = nums[middle];
        TreeNode left = sortedArrayToBST(nums, start, middle -1);
        TreeNode right = sortedArrayToBST(nums, middle + 1, end);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }

    public static void main(String[] argv) {
          new Solution().sortedArrayToBST(new int[]{1,2,3,4,5});
    }
}
