package leetcode.pro394;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        return decode(new Repeat(1, s));
    }

    public static class Repeat {
        int cnt;
        String str;
        Repeat(final int cnt, String str) {
            this.cnt = cnt;
            this.str = str;
        }
    }

    public static String decode(Repeat repeat) {
        // [ 的位置
        // cnt 的大小
        String ans = "";
        Stack<Integer> startStack = new Stack();
        Stack<Integer> cntStack = new Stack();
        int i = 0;
        while(i < repeat.str.length()) {
            if(repeat.str.charAt(i) == '[') {
                startStack.add(i);
                String number = "";
                for(int index = i - 1; index >= 0; index--) {
                    char c = repeat.str.charAt(index);
                    if(c >='0' && c <='9') {
                        number = c + number;
                    } else {
                        break;
                    }
                }
                cntStack.add(Integer.parseInt(String.valueOf(number)));
            } else if(repeat.str.charAt(i) == ']') {
                if(startStack.size() == 1) {
                    int start = startStack.peek();
                    String repeatStr = repeat.str.substring(start + 1, i);
                    Integer repeatCnt = cntStack.peek();
                    ans += decode(new Repeat(repeatCnt, repeatStr));
                }
                startStack.pop();
                cntStack.pop();
            } else if(cntStack.isEmpty()) {
                char c = repeat.str.charAt(i);
                if(c >='0' && c <='9') {
                } else {
                    ans += c;
                }

            }
            i++;
        }
        String tmp = "";
        for(int j = 0; j < repeat.cnt; j++) {
            tmp += ans;
        }
        return tmp;
    }

    public static void main(String[] argv) {
        System.out.println(decode(new Repeat(1,
                "3[a]2[bc]")));
    }
}
