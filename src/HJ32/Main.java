package HJ32;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int l = s.length();
            int[][] dp = new int[l][l];
            for(int i = 0; i < l; i++) {
                dp[i][i] = 1;
            }

            for(int i = 0; i < l;i++) {
                for(int j = i - 1; j >=0; j--) {
                    if(i - dp[j][i-1] -1 < 0) {
                        continue;
                    } else {
                        int duicheng = i - dp[j][i-1] - 1;
                        if(s.charAt(duicheng) == s.charAt(i)) {
                            dp[j][i] = Math.max(dp[j][i], dp[j][i-1] + 2);
                        }
                    }
                }
            }
            int ans = 0;
            for(int i = 0; i < l;i++) {
                for(int j =0; j < l;j++) {
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            System.out.println(ans);

        }
    }
}