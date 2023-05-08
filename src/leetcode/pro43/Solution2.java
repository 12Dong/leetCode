package leetcode.pro43;

public class Solution2 {

//    123 456
//    56088
//    1 2 3
//    4 5 6
//      1 8
//    1 5

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len1 + len2];
        String nnum1 = "";
        for(int i = num1.length() - 1; i >= 0; i--) {
            nnum1 += num1.charAt(i);
        }
        String nnum2 = "";
        for(int i = num2.length() - 1; i >= 0; i--) {
            nnum2 += num2.charAt(i);
        }
        for(int i = 0; i < nnum1.length(); i++) {
            for(int j = 0; j < nnum2.length(); j++) {
                Integer numi = Integer.valueOf("" + nnum1.charAt(i));
                Integer numj = Integer.valueOf("" + nnum2.charAt(j));
                ans[i + j] += (numi * numj);
            }
        }
        int addition = 0;
        String a = "";
        for(int i = 0; i < ans.length; i++) {
            ans[i] += addition;
            addition = ans[i] / 10;
            ans[i] %= 10;
            a = String.valueOf(ans[i]) + a;
        }

        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == '0') {
                continue;
            } else {
                return a.substring(i, a.length());
            }
        }
        return "0";
    }

    public static void main(String[] argv) {
        new Solution2().multiply("123", "456");
    }
}
