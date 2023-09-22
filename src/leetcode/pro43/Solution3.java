package leetcode.pro43;

public class Solution3 {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int l3 = l1 + l2;
        int[] ans = new int[l1 + l2];
        for(int i = 0; i < l1; i++) {
            int n1 = num1.charAt(l1 - i - 1) - '0';
            for(int j = 0; j < l2; j++) {

                int n2 = (num2.charAt(l2 - j - 1)) - '0';
                int multi = n1 * n2;
                ans[l3 - i - j - 1] += multi;
            }
        }
        String anss = "";
        int addition = 0;
        for(int i = l3 - 1; i >= 0; i--) {
            ans[i] += addition;
            addition = ans[i] / 10;
            ans[i] = ans[i] % 10;
            anss = Integer.toString(ans[i]) + anss;
        }

        for(int i = 0; i < anss.length(); i++) {
            if(anss.charAt(i) != '0') {
                return anss.substring(i);
            }
        }
        return "0";

    }

    public static void main(String[] argv) {
        new Solution3().multiply("123", "456");
    }
}
