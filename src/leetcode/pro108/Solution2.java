package leetcode.pro108;

import java.util.Arrays;

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
 
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if(length == 0) {
            return null;
        }
        if(length == 1) {
            return new TreeNode(nums[0]);
        }
        int middle = length / 2;
        TreeNode leftNode = null;
        if(middle == 0) {

        } else {
            int[] left = Arrays.copyOfRange(nums, 0, middle);
            leftNode = sortedArrayToBST(left);
        }
        TreeNode rightNode = null;
        if(middle == length - 1) {

        } else {
            int[] right = Arrays.copyOfRange(nums, middle + 1, nums.length);
            rightNode = sortedArrayToBST(right);
        }
        TreeNode m = new TreeNode(nums[middle]);
        m.left = leftNode;
        m.right = rightNode;
        return m;
    }
}
