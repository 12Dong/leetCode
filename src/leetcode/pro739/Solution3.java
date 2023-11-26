package leetcode.pro739;

import java.util.Stack;

public class Solution3 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> minStack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            if(minStack.isEmpty()) {
                minStack.add(i);
            } else {
                while(!minStack.isEmpty() && temperatures[minStack.peek()] < temperatures[i]) {
                    int index = minStack.pop();
                    ans[index] = i - index;
                }
                minStack.add(i);
            }
        }
        while(!minStack.isEmpty()) {
            ans[minStack.pop()] = 0;
        }
        return ans;
    }
}
