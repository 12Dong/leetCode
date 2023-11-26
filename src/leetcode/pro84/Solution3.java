package leetcode.pro84;

import java.util.Stack;

public class Solution3 {
    public int largestRectangleArea(int[] heights) {
        int[] hh = new int[heights.length + 2];
        hh[0] = 0;
        for(int i = 0; i < heights.length; i++) {
            hh[i + 1] = heights[i];
        }
        hh[hh.length - 1] = 0;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < hh.length; i++) {
            while(!stack.isEmpty() && hh[stack.peek()] > hh[i]) {
                int index = stack.pop();
                int h = hh[index];
                int r = i;
                int l = stack.peek();
                ans = Math.max(ans, h * (r - l - 1));
            }
            stack.add(i);
        }
        return ans;
    }
}
