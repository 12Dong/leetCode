package pro113;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> ans = new LinkedList<>();
        find(root, 0, targetSum, new LinkedList<>(), ans);
        return ans;

    }

    public static Boolean find(TreeNode curNode, int curValue, int target, List<Integer> curList, List<List<Integer>> ans) {
        if(curNode.left == null && curNode.right == null) {
            if(curValue + curNode.val == target) {
                curList.add(curNode.val);
                ans.add(new LinkedList<>(curList));
                curList.remove(curList.size() - 1);
            }
        }
        if(curNode.left != null) {
            curList.add(curNode.val);
            find(curNode.left, curValue + curNode.val, target, curList, ans);
            curList.remove(curList.size() - 1);
        }
        if(curNode.right != null) {
            curList.add(curNode.val);
            find(curNode.right, curValue + curNode.val, target, curList, ans);
            curList.remove(curList.size() - 1);
        }
        return false;
    }

}
