package leetcode.pro85;

import java.util.Stack;

public class Solution3 {

    public int maximalRectangle(char[][] matrix) {
        int[] cnt = new int[matrix[0].length];
        int ans = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    cnt[j]++;
                } else {
                    cnt[j] = 0;
                }
            }
            ans = Math.max(ans, maxArea(cnt));
        }
        return ans;
    }


    public int maxArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int[] h = new int[height.length + 2];
        h[0] = 0;
        for(int i = 0; i < height.length; i++) {
            h[i + 1] = height[i];
        }
        h[h.length - 1] = 0;
        for(int i = 0; i < h.length; i++) {
            if(stack.isEmpty()) {
                stack.add(i);
            } else {
                while(!stack.isEmpty() && h[i] < h[stack.peek()]) {
                    int location = stack.pop();
                    int hh = h[location];
                    int ll = (i - stack.peek() - 1);
                    ans = Math.max(hh * ll, ans);
                }
                stack.add(i);
            }
        }
        return ans;
    }
}
