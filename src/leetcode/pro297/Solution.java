package leetcode.pro297;

import java.util.*;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node == null ? "null" : Integer.toString(node.val));
            if(node == null) {
                continue;
            } else {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return list.toString();
    }

//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        String[] values = data.substring(1, data.length() - 1).split(",");
//        List<String> dataList = new LinkedList<String>(Arrays.asList(values));
//        return reDeserialize(dataList);
//    }

//    public TreeNode reDeserialize(List<String> list) {
//        if(list.get(0).equals("null")) {
//            list.remove(0);
//            return null;
//        }
//        TreeNode cur = new TreeNode(Integer.parseInt(list.get(0)));
//        list.remove(0);
//        cur.left = reDeserialize(list);
//        cur.right = reDeserialize(list);
//        return cur;
//    }
public TreeNode deserialize(String data) {
    if (data == "") {
        return null;
    }
    data = data.replace(" ", "");
    data = data.substring(1,  data.length() - 1);
    Queue<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
    TreeNode root = null;
    if(nodes.peek().equals("null")) {
        root = null;
        return root;
    } else {
        root = new TreeNode(Integer.valueOf(nodes.poll()));
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        String left = nodes.poll();
        String right = nodes.poll();
        if (!left.equals("null")) {
            node.left = new TreeNode(Integer.parseInt(left));
            queue.add(node.left);
        }
        if (!right.equals("null")) {
            node.right = new TreeNode(Integer.parseInt(right));
            queue.add(node.right);
        }
    }
    return root;
}

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
