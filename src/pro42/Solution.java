package pro42;

import java.util.Stack;

public class Solution {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < height.length; i++) {
            if(stack.isEmpty()) {
                stack.add(i);
                continue;
            }
            if(height[i] <= height[stack.peek()]) {
                stack.add(i);
            } else {
                while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    if(stack.size() == 1) {
                        stack.pop();
                        break;
                    }
                    int cbottom = stack.pop();
                    int left = stack.peek();
                    ans += (Integer.min(height[left], height[i]) - height[cbottom]) * (i - left - 1);
                }
                stack.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().trap(nums));
    }

//    public static int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

    public static int[] nums = new int[]{4,2,0,3,2,5};
}
