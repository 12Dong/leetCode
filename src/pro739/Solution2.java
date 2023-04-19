package pro739;

import java.util.Stack;

public class Solution2 {
//    输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            if(s.isEmpty()) {
                s.add(i);
            } else {
                while(!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                    int loc = s.pop();
                    ans[loc] = (i- loc);
                }
                s.add(i);
            }
        }
        while(!s.isEmpty()) {
            ans[s.pop()] = 0;
        }
        return ans;
    }
}
