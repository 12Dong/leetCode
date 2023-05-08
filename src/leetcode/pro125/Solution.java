package leetcode.pro125;

public class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        s = s.toLowerCase();
        while(l < r ) {
            while(!(('a' <= s.charAt(l) && s.charAt(l) <= 'z') || ('A' <= s.charAt(l) && s.charAt(l) <= 'Z') ||
                    ('0' <= s.charAt(l) && s.charAt(l) <= '9'))) {
                l++;
                if(l >= s.length()) {
                    return true;
                }
            }
            while(!(('a' <= s.charAt(r) && s.charAt(r) <= 'z') || ('A' <= s.charAt(r) && s.charAt(r) <= 'Z') ||
                    ('0' <= s.charAt(r) && s.charAt(r) <= '9'))) {
                r--;
                if(r < 0) {
                    return true;
                }
            }
            char lC = s.charAt(l);
            char rC = s.charAt(r);
            if(lC != rC) {
                return false;
            }
            l++;
            r--;
        }
        return true;

    }

    public static void main(String[] argv) {
        new Solution().isPalindrome("A man, a plan, a canal: Panama");
    }
}
