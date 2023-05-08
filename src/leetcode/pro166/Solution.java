package leetcode.pro166;

import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long lNumerator = (long) numerator;
        long lDenominator =(long) denominator;
        boolean sign = true;
        if(lNumerator > 0 && lDenominator < 0) {
            sign = false;
        } else if(lNumerator < 0 && lDenominator > 0) {
            sign = false;
        }
        lNumerator = Math.abs(lNumerator);
        lDenominator = Math.abs(lDenominator);
        long digital = lNumerator / lDenominator;
        long rest = lNumerator % lDenominator;
        if(rest == 0) {
            if(sign) {
                return "" + digital;
            } else {
                return "-" + digital;
            }
        }
        Set<Long> cycle = new LinkedHashSet<>();
        long[] val = new long[2000];
        int index = 0;
        cycle.add(rest);
        rest *= 10;
        while(true) {
            if(rest >= lDenominator) {
                val[index] = rest;
                rest = rest % lDenominator;
                if(rest == 0) {
                    break;
                }
                if(cycle.contains(rest)) {
                    break;
                }
                cycle.add(rest);
                rest *= 10;

                index++;
            } else {
                val[index] = rest;
                if(rest == 0) {
                    break;
                }
                if(cycle.contains(rest)) {
                    break;
                }
                cycle.add(rest);
                rest *= 10;
                index++;
            }
        }
        String ans = "";
        ans += digital;
        ans += '.';
        for(int i = 0; i <= index; i++) {
            if(val[i] == rest * 10 && rest != 0) {
                ans+= "(" + val[i] / lDenominator;
            } else {
                ans += val[i] / lDenominator;
            }
        }
        if(rest != 0) {
            ans += ")";
        }
        if(!sign) {
            return "-" + ans;
        }
        return ans;

    }

    public static void main(String[] argv){
        new Solution().fractionToDecimal(-2147483648, 1);
    }
}
