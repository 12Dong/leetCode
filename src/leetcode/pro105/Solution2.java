package leetcode.pro105;

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int middle = preorder[0];
        int middleIndex = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == middle) {
                middleIndex = i;
                break;
            }
        }
        TreeNode node = new TreeNode(middle);
        int lLength = 0;
        if(middleIndex != 0) {
            int[] lInorder = Arrays.copyOfRange(inorder, 0, middleIndex);
            int[] lPreoder = Arrays.copyOfRange(preorder, 1, 1 + lInorder.length);
            lLength = lInorder.length;
            TreeNode left = buildTree(lPreoder, lInorder);
            node.left = left;
        }
        if(middleIndex != inorder.length - 1) {
            int[] rInorder = Arrays.copyOfRange(inorder, middleIndex + 1, inorder.length);
            int[] rPreorder = Arrays.copyOfRange(preorder, 1 + lLength, preorder.length);
            TreeNode right = buildTree(rPreorder, rInorder);
            node.right = right;
        }
        return node;
    }
}
