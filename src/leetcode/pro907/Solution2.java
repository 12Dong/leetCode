package leetcode.pro907;

import java.util.Stack;

public class Solution2 {
    public int sumSubarrayMins(int[] arr) {
        int[] lMin = new int[arr.length];
        int[] rMin = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                lMin[i] = -1;
                stack.add(i);
            } else {
                while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    lMin[i] = -1;
                } else {
                    lMin[i] = stack.peek();
                }
                stack.add(i);
            }
        }
        stack.clear();
        for(int i = arr.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                rMin[i] = arr.length;
                stack.add(i);
            } else {
                while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    rMin[i] = arr.length;
                } else {
                    rMin[i] = stack.peek();
                }
                stack.add(i);
            }
        }

        long ans = 0;
        int mod = 1000000007;
        for(int i = 0; i < arr.length; i++) {
            long a = (i - lMin[i]);
            long b = (rMin[i]) - i;
            ans = (ans + a % mod * b % mod * (long)arr[i] % mod) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] argv) {
        System.out.print(new Solution2().sumSubarrayMins(new int[]{3,2,4,2}));
    }
}
