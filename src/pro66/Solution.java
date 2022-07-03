package pro66;

import java.util.Arrays;

public class Solution {

    public int[] plusOne(int[] digits) {
        int up = 1;
        for(int index = digits.length - 1; index >=0; index --) {
            digits[index] = digits[index] + up;
            if(digits[index] >= 10) {
                up = 1;
                digits[index] = digits[index] - 10;
            } else {
                up = 0;
            }
        }
        if(up == 0) {
            return digits;
        } else {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            for(int i = 1; i < ans.length; i++) {
                ans[i] = digits[i - 1];
            }
            return ans;
        }
    }
}
