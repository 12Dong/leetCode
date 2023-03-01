package HJ38;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            double distance = 0.0;
            double length = 0.0;
            double cur = (double) a;
            for(int i = 0; i < 5; i++) {
                distance += cur;
                cur /= 2;
                distance += cur;
            }
            System.out.println(String.format("%.6f", distance - cur));
            System.out.println(String.format("%.6f", cur));
        }
    }
}
