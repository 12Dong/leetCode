package HJ52;

import java.util.Objects;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            int n = a.length();
            int m = b.length();
            int[][] dp = new int[n + 1][m + 1];
            for(int i = 1; i <= n; i++) {
                dp[i][0] = i;
            }
            for(int i = 1; i <= m; i++) {
                dp[0][i] = i;
            }
            for(int i = 0; i < n;i++){
                for(int j = 0; j < m;j ++) {
                    if(Objects.equals(a.charAt(i), b.charAt(j))) {
                        dp[i+1][j+1] = dp[i][j];
                    } else {
                        int value = Math.min(dp[i+1][j], dp[i][j+1]);
                        value = Math.min(value, dp[i][j]);
                        dp[i+1][j+1] = value + 1;
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}