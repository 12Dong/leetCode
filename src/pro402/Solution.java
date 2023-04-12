package pro402;

import java.util.Stack;

public class Solution {
    public String removeKdigits(String num, int k) {
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < num.length(); i ++) {
            Character c = num.charAt(i);
            int n = Integer.valueOf("" + c);
            if(stack.isEmpty() || stack.peek() <= n) {
                stack.add(n);
            } else {
                while(k > 0 && !stack.isEmpty() && stack.peek() > n) {
                    k--;
                    stack.pop();
                }
                stack.add(n);
            }
        }
        while(k > 0) {
            stack.pop();
            k--;
        }
        String ans = "";
        while(!stack.isEmpty()) {
            String c = String.valueOf(stack.pop());
            ans = c + ans;
        }
        int start = ans.length();
        for(int i = 0; i < ans.length(); i++) {
            if(ans.charAt(i) == '0') {

            } else {
                start = i;
                break;
            }
        }
        ans = ans.substring(start, ans.length());
        return ans.length() == 0 ? "0" : ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().removeKdigits("100", 1));
    }

    // 1 2 1 9 1
    // 1 2 1 1
    // 1 1 9 1
    // 1 4 3 2 2 1 9  k = 3
    // 1 2 1 9
    // 1 0 2 0 0 k = 1
    // 0 200
    //
}
