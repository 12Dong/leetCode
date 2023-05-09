package leetcode.pro456;

import java.util.Stack;

public class Solution {

//    1,2,3,4
//    1,1,1,1
//    1,2,3,4

//    3,1,4,2
//    3,1,1,1
//    1,1,2,2

//    -1,3,2,0
//    -1, -1, -1, -1
//    -1, 0, 0, 0

    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int k = Integer.MIN_VALUE;
        int ans = -1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(stack.isEmpty()) {
                stack.add(i);
            } else {
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    int tmp = stack.pop();
                    k = Math.max(k, nums[tmp]);
                }
                if(nums[i] < k) {
                    ans = i;
                }
                stack.add(i);
            }
        }
        return ans != -1;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().find132pattern(new int[]{-2,1,1,-2,1,2}));
    }
}
//   1, 0, 1,-4,-3
//   1, 0, 0,-4,-4
//  -4 -4 -4 -4 -3
//   1  1  1  -3 -4

// 3,5,0,3,4
// 3,3,0,0,0
// 0,0,0,3,4

// [-2, 1, 1,-2, 1, 1]
//  -2 -2 -2 -2 -2 -2
//  -2 -2 -2 -2  1  1
//   1  1  1  1  1  1

//  -2,1,1,-2,1,2
//  -2-2-2 -2-2-2
//  -2-2-2 -2 1 2
//   2 2 2  2 2 2