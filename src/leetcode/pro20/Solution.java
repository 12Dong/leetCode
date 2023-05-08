package leetcode.pro20;

import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        List left = new LinkedList();
        left.add('(');
        left.add('{');
        left.add('[');
        List right = new LinkedList();
        right.add(')');
        right.add('}');
        right.add(']');
        for(int i = 0;i < s.length(); i++) {
            char cur = s.charAt(i);
            if(left.contains(cur)) {
                stack.add(cur);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char top = (char)stack.pop();
                if(cur == ')' && top == '(') {
                    continue;
                } else if(cur == ']' && top == '[') {
                    continue;
                } else if(cur == '}' && top == '{') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().isValid(str));
    }

//    public static String str = "()";
//    public static String str = "()[]{}";
//    public static String str = "(]";
//    public static String str = "([)]";
    public static String str =  "{[]}";
}
