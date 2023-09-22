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
                while(!minStack.isEmpty() && height[i] > height[minStack.peek()]) {
                    int index = minStack.pop();
                    // 宽 * 高
                    if(minStack.isEmpty()) {
                        continue;
                    }
                    int addition = (i - minStack.peek() - 1) * (Math.min(height[minStack.peek()], height[i]) - height[index]);
                    ans += addition;
                }
                minStack.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution2().trap(new int[]{0,1,0,2,1,0,1});
    }
}
