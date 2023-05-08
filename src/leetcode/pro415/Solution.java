package leetcode.pro415;

public class Solution {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int addition = 0;
        String ans = "";
        while(index1 != -1 || index2 != -1) {
            int n1 = 0;
            if(index1 >= 0) {
                Character c1 = num1.charAt(index1);
                n1 = Integer.valueOf("" + c1);
                index1 --;
            }
            int n2 = 0;
            if(index2 >= 0) {
                Character c2 = num2.charAt(index2);
                n2 = Integer.valueOf("" + c2);
                index2 --;
            }
            int sum = n1 + n2 + addition;
            if(sum >= 10) {
                addition = 1;
                sum -= 10;
            } else {
                addition = 0;
            }
            ans = sum + ans;
        }
        if(addition != 0) {
            ans = addition + ans;
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().addStrings("99", "1"));
    }
}
