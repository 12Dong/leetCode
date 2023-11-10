package aModule;

import java.util.Arrays;

public class Xing {

    public static int find(int number) {
        int[] dp = new int[number + 1];
        Arrays.fill(dp, 1);
        int ans = 0;
        for(int i = 2; i <= number; i++) {
            if(dp[i] == 1) {
                ans++;
                for(int j = 2; j * i <= number; j++) {
                    dp[i * j] = 0;
                }
            } else {
                continue;
            }
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(find(10));
    }
}
