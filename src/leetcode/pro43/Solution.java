package leetcode.pro43;

public class Solution {

    public String multiply(String num1, String num2) {
        int[] numa = new int[num1.length()];
        int[] numb = new int[num2.length()];
        int[] sum = new int[num1.length() + num2.length() + 1];
        for(int i = 0; i < num1.length(); i++) {
            numa[i] = Integer.parseInt("" + num1.charAt(num1.length() - i - 1));
        }
        for(int i = 0; i < num2.length(); i++) {
            numb[i] = Integer.parseInt("" + num2.charAt(num2.length() - i - 1));
        }

        for(int i = 0; i < num1.length(); i++) {
            for(int j =0; j < num2.length(); j++) {
                int location = (i) + (j);
                sum[location] += numa[i] * numb[j];
            }
        }

        int jinwei = 0;
        for(int i = 0; i < sum.length; i++) {
            sum[i] += jinwei;
            jinwei = sum[i] / 10;
            sum[i] = sum[i] % 10;
        }

        String ans = "";
        boolean check = true;
        for(int i = sum.length - 1; i >=0; i--) {
            if(check && sum[i] == 0) {
                continue;
            } else {
                check = false;
                ans += String.valueOf(sum[i]);
            }
        }
        ans = ans.equals("") ? "0" : ans;
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().multiply("123", "456"));
    }
}
