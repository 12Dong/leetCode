package leetcode.pro315;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public class Node {
        int val;
        int index;
        int count;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
            this.count = 0;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Node[] nodeList = new Node[nums.length];
        Node[] tmp = new Node[nums.length];
        for(int i = 0; i < nums.length; i++) {
            nodeList[i] = new Node(nums[i], i);
        }
        mergeSort(0, nums.length - 1, tmp, nodeList);
        int[] ans = new int[nums.length];
        for(int i = 0; i < nodeList.length; i++) {
            ans[nodeList[i].index] = nodeList[i].count;
        }
        List<Integer> a = new LinkedList<>();
        for(int i = 0; i< ans.length; i++) {
            a.add(ans[i]);
        }
        return a;
    }

    public void mergeSort(int l, int r, Node[] tmp, Node[] nums) {
        if(l>=r) {
            return;
        }
        int mid = (l+r)/2;
        mergeSort(l, mid, tmp, nums);
        mergeSort(mid + 1, r, tmp, nums);
        for(int index = l;index <= r;index++) {
            tmp[index] = nums[index];
        }
        int i = l;
        int j = mid + 1;
        for(int index = l; index <= r;index++) {
            if(i == mid + 1) {
                nums[index] = tmp[j];
                j++;
            } else if(j == r + 1) {
                tmp[i].count += (j - (mid+1));
                nums[index] = tmp[i];
                i++;
            } else if(tmp[i].val <= tmp[j].val) {
                tmp[i].count += (j -(mid+1));
                nums[index] = tmp[i];
                i++;
            } else if(tmp[i].val >= tmp[j].val){
                nums[index] = tmp[j];
                j++;
            }
         }

    }

    public static void main(String[] argv) {
        new Solution().countSmaller(nums);
    }

    public static int[] nums = new int[]{5,2,6,1};
}
