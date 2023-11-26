package leetcode.pro155;

import java.util.Stack;

public class Solution {
    class MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        Integer min = Integer.MAX_VALUE;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            min = Math.min(min, val);
            stack.add(val);
            minStack.add(min);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
            if(minStack.isEmpty()) {
                min = Integer.MAX_VALUE;
            } else {
                min = minStack.peek();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
