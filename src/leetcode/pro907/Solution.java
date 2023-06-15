package leetcode.pro907;

import java.util.Stack;

public class Solution {
    public int sumSubarrayMins(int[] arr) {
        long mod = 1000000007;
        long ans = 0;
        int[] l = new int[arr.length];
        int[] r = new int[arr.length];
        Stack<Integer> upStack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(upStack.isEmpty()) {
                l[i] = 0;
                upStack.add(i);
            } else {
                while(!upStack.isEmpty() && arr[upStack.peek()] >= arr[i]) {
                    upStack.pop();
                }
                if(!upStack.isEmpty()) {
                    l[i] = (i - upStack.peek() - 1);
                } else {
                    l[i] = i;
                }
                upStack.add(i);
            }
        }
        upStack.clear();
        for(int i = arr.length - 1; i >= 0; i--) {
            if(upStack.isEmpty()) {
                r[i] = 0;
                upStack.add(i);
            } else {
                while(!upStack.isEmpty() && arr[upStack.peek()] > arr[i]) {
                    upStack.pop();
                }
                if(!upStack.isEmpty()) {
                    r[i] = (upStack.peek() - i - 1);
                } else {
                    r[i] = arr.length - i - 1;
                }
                upStack.add(i);
            }
        }

        for(int i = 0; i < arr.length; i++) {
            long a = (l[i] + 1);
            long b = (r[i] + 1);
            ans = (ans + a % mod * b % mod * (long)arr[i] % mod) % mod;
        }

        return (int)ans;
    }

//    [3] 3
//    [1] [3,1] 2
//    [2] [1,2] [3,1,2] 4
//    [4] [2,4] [1,2,4] [3,1,2,4] 4


    public static void main(String[] argv) {
        System.out.println(new Solution().sumSubarrayMins(new int[]{3,1,2,4}));
    }
}
