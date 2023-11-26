package leetcode.pro42;

import java.util.Stack;

public class Solution2 {

    public int trap(int[] height) {
        Stack<Integer> minStack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < height.length; i++) {
            if(minStack.isEmpty()) {
                minStack.add(i);
            } else {
                while(!minStack.isEmpty() && height[minStack.peek()] < height[i]) {
                    int bottom = height[minStack.pop()];
                    if(!minStack.isEmpty()) {
                        int h = Math.min(height[minStack.peek()], height[i]) - bottom;
                        int r = i;
                        int l = minStack.peek();
                        ans += (h * (r - l - 1));
                    }
                }
                minStack.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution2().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
