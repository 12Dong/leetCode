package leetcode.pro456;

import java.util.Stack;

public class Solution4 {
    public static boolean find132pattern(int[] nums) {
        Stack<Integer> minStack = new Stack<>();
        // 记录target 右侧 最大的值
        Integer max = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i --) {
            if(minStack.isEmpty()) {
                minStack.add(nums[i]);
            } else {
                if(nums[i] < max) {
                    return true;
                }
                while(!minStack.isEmpty() && nums[i] > minStack.peek()) {
                    int value = minStack.pop();
                    max = Integer.max(max, value);
                }
                minStack.add(nums[i]);
            }
        }
        return false;
    }
}
