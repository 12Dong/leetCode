package leetcode.pro20;

import java.util.Stack;

public class Solution2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    Character top = stack.pop();
                    if(c == ')' && top == '(') {

                    } else if(c == ']' && top == '[') {

                    } else if(c == '}' && top == '{') {

                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
