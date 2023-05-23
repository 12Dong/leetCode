package leetcode.pro456;

import java.util.Stack;

class Solution2 {
    public boolean find132pattern(int[] nums) {
        int k = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < k) {
                return true;
            }
            if(stack.isEmpty()) {
                stack.add(nums[i]);
            } else {
                while(!stack.isEmpty() && stack.peek() < nums[i]) {
                    k = Math.max(k, stack.pop());
                }
                stack.add(nums[i]);
            }
        }
        return false;
    }
}