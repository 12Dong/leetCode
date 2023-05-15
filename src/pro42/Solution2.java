package pro42;

import java.util.Stack;

public class Solution2 {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        Integer ans = 0;
        for(int i = 0; i < height.length; i++) {
            if(stack.isEmpty()) {
                stack.add(i);
                continue;
            }
            if(height[stack.peek()] >= height[i]) {
                stack.add(i);
                continue;
            } else {
                while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    if(stack.size() == 1) {
                        stack.pop();
                        break;
                    }
                    int location = stack.pop();
                    ans+= (Math.min(height[stack.peek()], height[i]) - height[location]) * (i - stack.peek() - 1);
                }
                stack.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution2().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}

