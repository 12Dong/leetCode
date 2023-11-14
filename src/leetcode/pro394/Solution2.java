package leetcode.pro394;

import java.util.Stack;

public class Solution2 {
    public String decodeString(String s) {
        // 做括号位置
        Stack<Integer> stack = new Stack<>();
        Stack<String> preS = new Stack<>();
        Stack<Integer> cntStack = new Stack<>();
        String tmp = "";
        String n = "";
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(s.charAt(i) == '[') {
                stack.add(i);
                if(tmp.length() > 0) {
                    preS.add(tmp);
                }
                int cnt = Integer.valueOf(n);
                cntStack.add(cnt);
                n = "";
                tmp = "";
            } else if(c >= '0' && c <= '9') {
                n += c;
            } else if(c == ']') {
                // 处理重复 cntStack 和 tmp
                int cnt = cntStack.pop();
                String replace = "";
                for(int index = 0; index < cnt; index++){
                    replace += tmp;
                }
                String pre = "";
                if(cntStack.isEmpty() && !preS.isEmpty()) {
                    pre = preS.pop();
                }
                tmp = pre + replace;
            } else {
                tmp += c;
            }
        }
        return tmp;
    }

    public static void main(String[] argv) {
        new Solution2().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
    }
}
