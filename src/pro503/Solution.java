package pro503;

import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            if(stack.isEmpty()) {
                stack.add(i);
            } else {
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    ans[stack.pop()] = nums[i];
                }
                stack.add(i);
            }
        }
        if(stack.isEmpty()) {
            return ans;
        }
        for(int i = 0; i < nums.length; i++) {
            if(stack.isEmpty()) {
                break;
            }
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                ans[stack.pop()] = nums[i];
            }
        }
        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        return ans;
    }
}
