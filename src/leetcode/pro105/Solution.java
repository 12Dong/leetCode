package leetcode.pro105;

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

    /**
     * [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     */

//    [1,2,3]
//    [2,3,1]
//    [1,2,null,null,3]
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }



    public TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if(pe < ps || ie < is) {
            return null;
        }
        TreeNode cur = new TreeNode();
        cur.val = preorder[ps];
        // 找 cur.val 在 inorder 中的位置 curLocation
        // curLocation 之前的是 左子树
        // curLocation 之后的是 右子树
        int curLocation = is;
        for(int i = is; i <= ie; i++) {
            if(inorder[i] == cur.val) {
                curLocation = i;
            }
        }

        TreeNode left = buildTree(preorder, ps + 1, ps + (curLocation - is), inorder, is, curLocation - 1);
        TreeNode right = buildTree(preorder, ps + (curLocation - is) + 1, pe, inorder, curLocation + 1, ie);
        cur.left = left;
        cur.right = right;
        return cur;
        // is - > curLocation - 1 左子树
        // curLocation + 1 -> ie 右子树
        // 划分左子树 最右节点
//        if(curLocation == is && curLocation == ie) {
//            // 没有左子数 没有右子树
//            return cur;
//        } else if(curLocation == is){
//            // 没有左子树
//            TreeNode right = buildTree(preorder, ps + 1, pe, inorder, curLocation + 1, ie);
//            cur.right = right;
//            return cur;
//        } else if(curLocation == ie) {
////    [1,2,3]
////    [2,3,1]
////    [1,2,null,null,3]
//            // 没有右子树
//            TreeNode left = buildTree(preorder, ps + 1, pe, inorder, is, curLocation - 1);
//            cur.left = left;
//            return cur;
//        } else {
//
//            // 构造左子树
//            TreeNode left = buildTree(preorder, ps + 1, ps + (curLocation - is), inorder, is, curLocation - 1);
//            TreeNode right = buildTree(preorder, ps + (curLocation - is) + 1, pe, inorder, curLocation + 1, ie);
//            cur.left = left;
//            cur.right = right;
//            return cur;
//        }

    }

    public static void main(String[] argv) {
        new Solution().buildTree(new int[]{1, 2, 3}, new int[]{2, 3, 1});
    }
}
