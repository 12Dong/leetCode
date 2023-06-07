package leetcode.pro459;

public class Solution {

    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public static void main(String[] argv) {
        System.out.println(new Solution().repeatedSubstringPattern("ababab"));
    }

}
