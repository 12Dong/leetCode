package HJ3;

import java.util.*;
import java.util.stream.Collectors;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int n = in.nextInt();
            for(int i = 0; i < n; i++) {
                int m = in.nextInt();
                if(map.get(m) != null) {

                } else {
                    map.put(m, 1);
                }
            }
            Set<Integer> keys = map.keySet();
            List<Integer> l = keys.stream().sorted().collect(Collectors.toList());
            for(Integer num : l) {
                System.out.println(num);
            }

        }
    }
}
