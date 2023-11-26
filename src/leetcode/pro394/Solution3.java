package leetcode.pro394;

import java.util.Stack;

public class Solution3
{
    public String decodeString(String s) {
        String tmp = "";
        String cnt = "";
        Stack<Integer> cntStack = new Stack<>();
        Stack<String> preStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                cnt += c;
            } else if(c == '[') {
                cntStack.add(Integer.parseInt(cnt));
                preStack.add(tmp);
            } else if(c == ']') {
                Integer repeat = cntStack.pop();
                tmp = repeat(tmp, repeat);
                String last = preStack.pop();
                tmp = last + tmp;
            } else {
                tmp += c;
            }
        }
        return tmp;
    }

    public String repeat(String s, int cnt) {
        String ans = "";
        for(int i = 0; i < cnt; i++) {
            ans += s;
        }
        return ans;
    }

}
