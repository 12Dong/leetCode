package leetcode.pro739;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i ++) {
            if(stack.isEmpty()) {
                stack.add(i);
                continue;
            }
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int l = stack.pop();
                ans[l] = i - l;
            }
            stack.add(i);
        }

        while(!stack.isEmpty()) {
            int l = stack.pop();
            ans[l] = 0;
        }
        return ans;
    }

    public static void main(String[] argv) {
        int[] nums = new int[]{73,74,75,71,69,72,76,73};
        new Solution().dailyTemperatures(nums);
        nums = new int[]{30,40,50,60};
        new Solution().dailyTemperatures(nums);
    }
}
