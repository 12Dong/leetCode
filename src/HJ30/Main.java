package HJ30;

import java.util.*;
import java.*;

import java.*;
import java.util.stream.Collectors;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        map.put("1", "0001");
        map.put("2", "0010");
        map.put("3", "0011");
        map.put("4", "0100");
        map.put("5", "0101");
        map.put("6", "0110");
        map.put("7", "0111");
        map.put("8", "1000");
        map.put("9", "1001");
        map.put("A", "1010");
        map.put("B", "1011");
        map.put("C", "1100");
        map.put("D", "1101");
        map.put("E", "1110");
        map.put("F", "1111");
        map.put("0001", "1");
        map.put("0010", "2");
        map.put("0011", "3");
        map.put("0100", "4");
        map.put("0101", "5");
        map.put("0110", "6");
        map.put("0111", "7");
        map.put("1000", "8");
        map.put("1001", "9");
        map.put("1010", "A");
        map.put("1011", "B");
        map.put("1100", "C");
        map.put("1101", "D");
        map.put("1110", "E");
        map.put("1111", "F");
        map.put("0", "0000");
        map.put("0000", "0");
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            String b = in.next();
            String c = a + b;
            List<Character> cs1 = new LinkedList<>();
            List<Character> cs2 = new LinkedList();
            for(int i = 0; i < c.length(); i ++) {
                Character cc = c.charAt(i);
                if(i % 2 == 0) {
                    cs1.add(cc);
                } else {
                    cs2.add(cc);
                }
            }
            cs1 = cs1.stream().sorted().collect(Collectors.toList());
            cs2 = cs2.stream().sorted().collect(Collectors.toList());
            String ans = "";
            List<Character> cs3 = new LinkedList();
            for(Character cc : cs1) {
                System.out.println();
                cc = ("" + cc).toUpperCase(Locale.ROOT).charAt(0);
                String tmp = "" + cc;
                String convert = map.get(tmp);
                String tmpS = "";
                for(int index = convert.length() -1; index >=0; index--) {
                    tmpS = tmpS + convert.charAt(index);
                }
                String result = map.get(tmpS);
                cs3.add(result.charAt(0));
            }
            List<Character> cs4 = new LinkedList();
            for(Character cc : cs2) {
                cc = ("" + cc).toUpperCase(Locale.ROOT).charAt(0);
                String tmp = "" + cc;
                String convert = map.get(tmp);
                String tmpS = "";
                for(int index = convert.length() -1; index >=0; index--) {
                    tmpS = tmpS + convert.charAt(index);
                }
                String result = map.get(tmpS);
                cs4.add(result.charAt(0));
            }
            int index = 0;
            for(; index < cs3.size() && index < cs4.size(); index++) {
                ans += cs3.get(index);
                ans += cs4.get(index);
            }

            for(; index < cs3.size(); index++) {
                ans += cs3.get(index);
            }

            for(; index < cs4.size(); index++) {
                ans += cs4.get(index);
            }
            System.out.println(ans);
        }
    }

    static Map<String, String> map = new HashMap<String, String>();
}