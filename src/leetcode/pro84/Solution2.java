package leetcode.pro84;

import java.util.Stack;

public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int[] l = new int[heights.length];
        int[] r = new int[heights.length];
        // 第一个小于 h 的 index
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()) {
                stack.add(i);
            } else {
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    l[stack.pop()] = i;
                }
                stack.add(i);
            }
        }
        while(!stack.isEmpty()) {
            l[stack.pop()] = heights.length;
        }

        for(int i = heights.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                stack.add(i);
            } else {
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    r[stack.pop()] = i;
                }
                stack.add(i);
            }
        }
        while(!stack.isEmpty()) {
            r[stack.pop()] = -1;
        }

        int ans = 0;
        for(int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int w = l[i] - r[i] - 1;
            ans = Math.max(ans, h * w);
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution2().largestRectangleArea(new int[]{2,4});
    }
}