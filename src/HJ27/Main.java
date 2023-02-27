package HJ27;

import java.util.Scanner;

import java.util.*;
import java.util.stream.Collectors;// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            List<String> list = new LinkedList<>();
            for (int i = 0; i < n; i ++) {
                String s = in.next();
                list.add(s);
            }
            String bro = in.next();
            int k = in.nextInt();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < bro.length(); i++) {
                Integer cnt = map.getOrDefault((Character) bro.charAt(i), 0);
                map.put((Character) bro.charAt(i), cnt + 1);
            }
            List<String> ans = new LinkedList<>();

            for (String s : list) {
                if (s.length() != bro.length()) {
                    continue;
                }
                if(s.equals(bro)) {
                    continue;
                }
                Map<Character, Integer> compare = new HashMap<>();
                for (int i = 0; i < s.length(); i++) {
                    Integer cnt = compare.getOrDefault((Character) s.charAt(i), 0);
                    compare.put((Character) s.charAt(i), cnt + 1);
                }
                boolean sign = true;
                for(Character key : map.keySet()) {
                    Integer value = map.get(key);
                    if(!compare.containsKey(key)) {
                        sign  = false;
                        break;
                    }
                    if(compare.get(key) != value) {
                        sign  = false;
                        break;
                    }
                }

                for(Character key : compare.keySet()) {
                    Integer value = compare.get(key);
                    if(!map.containsKey(key)) {
                        sign  = false;
                        break;
                    }
                    if(map.get(key) != value) {
                        sign  = false;
                        break;
                    }
                }
                if(sign) ans.add(s);
            }
            ans = ans.stream().sorted().collect(Collectors.toList());
            System.out.println(ans.size());
            if(ans.size() >= k && k != 0) {
                System.out.println(ans.get(k - 1));
            }
            // for(String  ss : ans) {
            //     System.out.println(ss);
            // }
        }
    }
}