package pro215;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k , (a, b) -> b-a);
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        int ans = pq.peek();
        while(k >0) {
            ans = pq.poll();
            k--;
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().findKthLargest(nums, 1);
    }

    public static int[] nums = new int[]{1};
}
