package leetcode.pro726;

import java.util.*;

public class Solution {

    static class Pair {
        String str;
        int count;

        Pair(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }

//    输入：formula = "K4(ON(SO3)2)2"
//    输出："K4N2O14S4"
//    解释：原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。

    public String countOfAtoms(String formula) {
        Stack<Pair> stack = new Stack<>();
        int index = 0;
        while(index < formula.length()) {
            char c = formula.charAt(index);
            if(c == '(') {
                stack.add(new Pair("(", 1));
                index++;
            } else if(c == ')') {
                int next = index + 1;
                String strCnt = "";
                while(next < formula.length() && Character.isDigit(formula.charAt(next))) {
                    strCnt += formula.charAt(next);
                    next++;
                }
                int number = strCnt.equals("") ? 1 : Integer.valueOf(strCnt);
                List<Pair> list = new LinkedList<>();
                while(!stack.isEmpty()) {
                    Pair pair = stack.pop();
                    if(pair.str .equals("(")) {
                        for(Pair p : list) {
                            stack.add(p);
                        }
                        break;
                    }
                    pair.count *= number;
                    list.add(pair);
                }
                index = next;
            } else {
                String str = "" + formula.charAt(index);
                String strCnt = "";
                int next = index + 1;
                while(next < formula.length() && Character.isLowerCase(formula.charAt(next))) {
                    str += formula.charAt(next);
                    next++;
                }
                while(next < formula.length() && Character.isDigit(formula.charAt(next))) {
                    strCnt += formula.charAt(next);
                    next++;
                }
                int number = strCnt.equals("") ? 1 : Integer.valueOf(strCnt);
                Pair pair = new Pair(str, number);
                stack.add(pair);
                index = next;
            }
        }
        Map<String, Integer> map = new TreeMap<>();
        while(!stack.isEmpty()) {
            Pair pair = stack.pop();
            map.put(pair.str, map.getOrDefault(pair.str, 0) + pair.count);
        }
        String ans = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            ans += entry.getKey() + (entry.getValue() == 1 ? "" : entry.getValue());
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().countOfAtoms("H2O"));
        System.out.println(new Solution().countOfAtoms("Mg(OH)2"));
        System.out.println(new Solution().countOfAtoms("K4(ON(SO3)2)2"));
    }
}
