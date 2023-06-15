package leetcode.pro581;

import java.util.Stack;

public class Solution2 {

//    [2,6,4,8,10,9,15]



    public int findUnsortedSubarray(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            if(stack.isEmpty()) {
                l[i] = -1;
                stack.add(i);
            } else {
                while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    l[i] = stack.peek();
                } else {
                    l[i] = -1;
                }
                stack.add(i);
            }
        }
        stack.clear();
        for(int i = nums.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                r[i] = nums.length;
                stack.add(i);
            } else {
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    r[i] = stack.peek();
                } else {
                    r[i] = nums.length;
                }
                stack.add(i);
            }
        }

        int ls = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if(l[i] != i - 1) {
                ls = Math.min(ls, l[i]);
            }
        }

        int rs = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            if(r[i] != i + 1) {
                rs = Math.max(rs, r[i]);
            }
        }

        if(ls == Integer.MAX_VALUE || rs == Integer.MIN_VALUE) {
            return 0;
        } else {
            return (rs - 1) - (ls + 1) + 1;
        }

    }

    public static void main(String[] argv) {
        System.out.println(new Solution2().findUnsortedSubarray(new int[]{1,3,2,3,3}));
    }
}
