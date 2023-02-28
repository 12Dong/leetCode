package HJ41;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;


// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    static Integer ans = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            ans = 0;
            int n = in.nextInt();
            int[] m = new int[n];
            int[] cnt = new int[n];
            for(int i = 0; i < n; i++) {
                m[i] = in.nextInt();
            }
            for(int i = 0;i<n;i++){
                cnt[i] = in.nextInt();
            }
            List<Integer> list = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            set.add(0);
            for(int i = 0; i < n;i++) {
                for(int j = 1; j <= cnt[i]; j++) {
                    Set<Integer> newSet = new HashSet<>(set);
                    for(Integer num : set) {
                        newSet.add(num + m[i]);
                    }
                    set.addAll(newSet);
                }
            }

            System.out.println(set.size());

        }
    }

}
