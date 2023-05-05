package pro862;

import java.util.ArrayDeque;

public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] prefix = new long[nums.length + 1];
        long sum = 0;
        prefix[0] = sum;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i + 1] = sum;
        }
        int ans = Integer.MAX_VALUE;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
        for(int i = 0; i <= nums.length; i++) {
            while(!arrayDeque.isEmpty() && prefix[i] - prefix[arrayDeque.peekFirst()] >= k) {
                ans = Math.min(ans, i - arrayDeque.peekFirst());
                arrayDeque.pollFirst();
            }
            while(!arrayDeque.isEmpty() && prefix[i] <= prefix[arrayDeque.peekLast()]) {
                arrayDeque.pollLast();
            }
            arrayDeque.addLast(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().shortestSubarray(new int[]{1, 2}, 3));
    }
}
