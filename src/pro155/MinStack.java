package pro155;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    private Integer min;


    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        min = Integer.min(val, min);
        stack.add(val);
        minStack.add(min);
    }

    public void pop() {
        Integer stackPop = stack.pop();
        if(stackPop.equals(minStack.peek())) {
            minStack.pop();
            if(minStack.isEmpty()) {
                min = Integer.MAX_VALUE;
            } else {
                min = minStack.peek();
            }
        } else {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
