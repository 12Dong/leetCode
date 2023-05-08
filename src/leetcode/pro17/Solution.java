package leetcode.pro17;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public char[][] telephone = new char[][]{
            {' '},
            {' '},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new LinkedList<>();
        List<String> ans = new LinkedList<>();
        dfs(ans, "", 0, digits);
        return ans;
    }

    public void dfs(List<String> ans, String cur, int index, String src) {
        if(index == src.length()) {
            ans.add(cur);
            return;
        }
        char c = src.charAt(index);
        int number = Integer.valueOf("" + c);
        for(int i = 0; i < telephone[number].length; i++) {
            String next = cur + telephone[number][i];
            dfs(ans, next, index + 1, src);
        }
    }


    public static void main(String[] argv) {
        new Solution().letterCombinations("23");
    }
}
