package leetcode.pro6;

import java.util.Arrays;

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        String[] strs = new String[numRows];
        Arrays.fill(strs, "");
        int index = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            strs[index] += c;
            index+=sign;
            if(index == numRows || index == -1) {
                sign = -sign;
                if(sign > 0) {
                    index = 1;
                } else {
                    index = numRows - 2;
                }
            }
        }
        String ans = "";
        for(int i = 0; i < numRows; i++) {
            ans += strs[i];
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
    }
//    PAHNAPLSIIGYIR
//    PAHNAPLSIIGYIR
}
