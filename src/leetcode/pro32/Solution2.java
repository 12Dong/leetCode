package leetcode.pro32;

import java.util.Stack;

public class Solution2 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add(i);
            } else {
                stack.pop();
                if(!stack.isEmpty()) {
                    ans = Math.max(ans, i - stack.peek());
                } else {
                    stack.add(i);
                }
            }
        }
        return ans;
    }
}
