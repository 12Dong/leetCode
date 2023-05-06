package pro85;

import java.util.Stack;

public class Solution2 {
//    [
//    ["1","0","1","0","0"],
//    ["1","0","1","1","1"],
//    ["1","1","1","1","1"],
//    ["1","0","0","1","0"]]

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(height));
        }
        return ans;
    }

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
}
