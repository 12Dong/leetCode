package leetcode.pro151;

public class Solution {

    public String reverseWords(String s) {
        String ans = "";
        int end = -1;
        int start = -1;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == ' ') {
                if(end != -1) {
                    ans += s.substring(start, end + 1);
                    ans += " ";
                }
                end = -1;
                start = -1;
            } else if(end == -1) {
                end = i;
                start = i;
            } else {
                start = i;
            }
        }
        if(end != -1) {
            ans += s.substring(start, end + 1);
        } else {
            ans = ans.substring(0, ans.length() - 1);
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().reverseWords("  hello world ");
    }
}
