package leetcode.pro456;

import java.util.Stack;

public class Solution3 {
    public static boolean find132pattern(int[] nums) {
        Stack<Integer> minS = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(minS.isEmpty()) {
                minS.add(nums[i]);
            } else {
                if(nums[i] < max) {
                    return true;
                } else {
                    while(!minS.isEmpty() && nums[i] > minS.peek()) {
                        max = Math.max(max, minS.pop());
                    }
                    minS.add(nums[i]);
                }
            }

        }
        return false;
    }

    public static void main(String[] argv) {
        find132pattern(new int[]{1,2,3,4});
    }
}
