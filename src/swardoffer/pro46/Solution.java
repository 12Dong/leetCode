package swardoffer.pro46;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int translateNum(int num) {
        String strNum = String.valueOf(num);
        int[] dp = new int[strNum.length()];
        for(int i = 0; i < strNum.length(); i++) {
            if(i > 0) {
                dp[i] += dp[i - 1];
                if(i >= 1) {
                    char prev = strNum.charAt(i - 1);
                    if(prev == '0') {
                        continue;
                    }
                    int twoNumber = Integer.valueOf("" + prev + strNum.charAt(i));
                    if(twoNumber <= 25) {
                        if(i == 1) {
                            dp[i]++;
                        } else {
                            dp[i] += dp[i - 2];
                        }

                    }
                }
            } else {
                dp[0] = 1;
            }
        }
        return dp[strNum.length() - 1];
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().translateNum(12258));
    }
}
