package leetcode.pro84;

import java.util.Stack;

public class Solution {

//    2,1,5,6,2,3
//    10
    public int largestRectangleArea(int[] heights) {
        int[] h = new int[heights.length + 2];
        h[0] = 0;
        h[h.length - 1] = 0;
        for(int i = 0; i < heights.length; i++) {
            h[i + 1] = heights[i];
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < h.length; i++) {
            if(stack.isEmpty()) {
                stack.add(i);
            } else {
                while(!stack.isEmpty() && h[stack.peek()] > h[i]) {
                    int end = i;
                    while(!stack.isEmpty() && h[stack.peek()] > h[i]) {
                        int cur = stack.pop();
                        int hh = h[cur];
                        int ll = i - stack.peek() - 1;
                        ans = Math.max(ans, hh * ll);
                    }

                }
                stack.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().largestRectangleArea(new int[]{3,2,1,2,3,1,1,1}));
    }
}
