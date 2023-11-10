package aModule;

import java.util.*;
public class Kuaishou {
    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node5 = new Node(5);
        Node node1 = new Node(1);
        Node node4 = new Node(4);
        Node node6 = new Node(6);

        node3.left = node2;
        node3.right = node5;

        node2.left = node1;
        node5.left = node4;
        node5.right = node6;

        updateTree(node3);

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node3);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            if(cur.left != null) {
                queue.add(cur.left);
            }

            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    public static  class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static List<Integer> list = new LinkedList<>();
    public static int[] array;
    public static int[] prefixSum;
    public static int length = 0;

    public static Node updateTree(Node root) {
        getArray(root);
        // 换List
        array = new int[list.size()];
        for(int value : list) {
            array[length] = value;
            length++;
        }
        // 排序
        Arrays.sort(array);
        prefixSum = new int[list.size()];
        // for(int i = 0 ;i < array.length; i++) {
        //     System.out.println(array[i]);
        // }
        // 前缀和
        for(int i = 0; i < array.length; i++) {
            if(i == 0) {
                prefixSum[i] = array[i];
            } else {
                prefixSum[i] = array[i] + prefixSum[i - 1];
            }
        }

        // for(int i = 0 ;i < prefixSum.length; i++) {
        //     System.out.println(prefixSum[i]);
        // }

        // 修改值
        updateValue(root);
        return root;
    }

    public static void getArray(Node node) {
        list.add(node.value);
        if(node.left != null) {
            getArray(node.left);
        }

        if(node.right != null) {
            getArray(node.right);
        }
    }

    public static void updateValue(Node node) {
        // 二分法查找下标
        int index = binarySearch(node.value);
        System.out.println("value " + node.value + " index " + index);
        int value = prefixSum[length - 1] - prefixSum[index];
        if(index == length - 1) {
            node.value = 0;
        } else {
            node.value = (value / (length - 1 - index));
        }

        if(node.left != null) {
            updateValue(node.left);
        }
        if(node.right != null) {
            updateValue(node.right);
        }
    }

    // 找最大下标
    public static int binarySearch(int value) {
        int l = 0;
        int r = length - 1;
        int ans = 0;
        while(l <= r) {
            int middle = (l + r) / 2;
            if(array[middle] == value) {
                ans = middle;
                l = middle + 1;
            } else if(array[middle] > value) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return ans;
    }
}