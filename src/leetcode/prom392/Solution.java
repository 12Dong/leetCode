package leetcode.prom392;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        int index = 0;
        if(index == lengthS) return true;
        for(int i = 0; i < lengthT; i++){
            if(t.charAt(i) == s.charAt(index)) {
                index++;
                if(index == lengthS) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] argv){
        System.out.println(new Solution().isSubsequence(s, t));
    }

//    private static String s = "abc";
    private static String s = "axc";

//    private static String t = "ahbgdc";
    private static String t = "ahbgdc";
}
