package pro166;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public String fractionToDecimal(int numerator, int denominator) {
        long num1 = numerator;
        long num2 = denominator;
        boolean sign = true;
        if(num1 > 0 && num2 < 0) {
            sign = false;
        } else if(num1 < 0 && num2 > 0) {
            sign = false;
        }
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        if(num1 % num2 == 0) {

            String ans = String.valueOf(num1 / num2);
            if(!sign) {
                ans = "-" + ans;
            }
            return ans;
        }
        Map<String, Integer> restIndex = new HashMap<>();
        String ans = "";
        int index = 0;
        if(num1 > num2) {
            ans += (num1 / num2) + ".";
            num1 = num1 % num2;
        } else {
            ans += "0" + ".";
            num1 = num1 % num2;
        }
        index = ans.length();
        while(num1 != 0) {
            restIndex.put(Long.toString(num1), index++);
            num1 *= 10;
            String value = Long.toString(num1 / num2);
            String rest = Long.toString(num1 % num2);
            if(restIndex.containsKey(rest)) {
//                restIndex.put(rest, index++);
                ans += value;
                ans = String.format("%s(%s)", ans.substring(0, restIndex.get(rest)), ans.substring(restIndex.get(rest), ans.length()));
                break;
            } else {
//                restIndex.put(rest, index++);
                ans += value;
            }
            num1 = num1 % num2;
        }
        if(!sign) {
            ans = "-" + ans;
        }
        return ans;
    }

    public static void main(String[] argv) {
        System.out.println(new Solution2().fractionToDecimal(-4,333));
    }
}
