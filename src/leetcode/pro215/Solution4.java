package leetcode.pro215;

import java.util.PriorityQueue;

public class Solution4 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i ++) {
            if(q.size() < k) {
                q.add(nums[i]);
            } else {
                int top = q.peek();
                if(nums[i] > top) {
                    q.poll();
                    q.add(nums[i]);
                }
            }
        }
        return q.peek();
    }

    public static void main(String[] argv) {
        new Solution4().findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }
}
