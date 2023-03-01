package HJ24;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            int[] dpL = new int[n];
            int[] dpR = new int[n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < i; j++) {
                    if(nums[i] > nums[j]) {
                        dpL[i] = Math.max(dpL[i], dpL[j] + 1);
                    }
                }
            }

            for(int i = n - 1; i >= 0; i--) {
                for(int j = n - 1; j > i; j--) {
                    if(nums[i] > nums[j]) {
                        dpR[i] = Math.max(dpR[i], dpR[j] + 1);
                    }
                }
            }

            int ans = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++) {
                int maxNumber = dpL[i] + dpR[i] + 1;
                ans = Math.min(ans, n - maxNumber);
            }
            System.out.println(ans);
        }
    }
}
