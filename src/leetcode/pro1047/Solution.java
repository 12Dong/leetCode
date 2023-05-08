package leetcode.pro1047;

import java.util.Stack;

public class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
                if(stack.isEmpty()) {
                  stack.add(c);
                } else if(stack.peek() == c) {
                    stack.pop();
                    continue;
                } else {
                    stack.add(c);
                }
        }
        String ans = "";
        while(!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
