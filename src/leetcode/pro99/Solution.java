package leetcode.pro99;

public class Solution {
    
      public static class TreeNode {
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


    
    public void recoverTree(TreeNode root) {
        index = 0;
        TreeNode[] list = new TreeNode[1005];
        dfs(root, list);
        TreeNode a = null;
        TreeNode b = null;
        for(int i = 0; i < index; i++) {
            if(i == 0) {
                if(list[0].val > list[1].val) {
                    a = list[0];
                }
                continue;
            }

            if(i == index - 1) {
                if(list[i].val < list[i - 1].val) {
                    b = list[i];
                }
                continue;
            }

            if(list[i].val < list[i-1].val || list[i].val > list[i+1].val) {
                if(a == null) {
                    a = list[i];
                } else {
                    b = list[i];
                }
            }
        }

        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    static int index = 0;

    public void dfs(TreeNode cur, TreeNode[] list) {
        if(cur.left != null) {
            dfs(cur.left, list);
        }
        list[index++] = cur;
        if(cur.right != null) {
            dfs(cur.right, list);
        }
    }

    public static void main(String[] argv) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode1;
        new Solution().recoverTree(treeNode3);
    }
}
