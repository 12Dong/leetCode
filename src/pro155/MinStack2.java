package pro155;

import java.util.Stack;

public class MinStack2 {

    Stack<Integer> valueStack;
    Stack<Integer> minStack;

    Integer min;
    public MinStack2() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        min = Integer.min(val, min);
        valueStack.add(val);
        minStack.add(min);
    }

    public void pop() {
        valueStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();;
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return min;
    }
}
