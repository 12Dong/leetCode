package leetcode.pro82;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        for(int i = 0; i < heights.length; i++) {
            newHeights[i + 1] = heights[i];
        }
        newHeights[0] = 0;
        newHeights[heights.length + 1] = 0;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int right = 0; right < newHeights.length; right++){
            while(!stack.isEmpty() && newHeights[stack.peek()] > newHeights[right]) {
                int cur = stack.pop();
                int curH = newHeights[cur];
                int rr = right - 1;
                int ll = stack.peek();
                ans = Integer.max(ans, curH * (rr - ll));
            }
            stack.add(right);
        }

        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().largestRectangleArea(heights));
    }

//    public static int[] heights = new int[]{2,1,5,6,2,3};
    public static int[] heights = new int[]{2,4};
//    public static int[] heights = new int[]{2,1,2};
}
