package HJ61;


import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int m = in.nextInt();
            int n = in.nextInt();
            System.out.println(f(m, n));
        }
    }

    /**
     m 苹果数量
     n 盘子数量
     */
    public static int f(int m, int n) {
        if( n == 1) {
            return 1;
        }

        if(m == 1) {
            return 1;
        }

        if(m == 0) {
            return 1;
        }

        if(m < n) {
            return f(m, m);
        }

        return f(m, n - 1) + f(m - n,n);

    }
}