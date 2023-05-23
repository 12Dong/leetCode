package leetcode.pro680;

public class Solution {
    public boolean validPalindrome(String s) {
        return check(s, 1);
    }

    public boolean check(String s, int cnt) {
        int l = 0;
        int r = s.length() - 1;
        while(l <= r) {
            if(s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                if(cnt == 0) {
                    return false;
                } else {
                    return check(s.substring(l, r), 0) || check(s.substring(l + 1, r + 1), 0);
                }
            }
        }
        return true;
    }
}
