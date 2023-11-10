package leetcode.pro438;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cntP = new int[26];
        for(int i = 0; i < p.length(); i++) {
            Character c = p.charAt(i);
            cntP[c - 'a']++;
        }
        int[] cntS = new int[26];
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            cntS[s.charAt(i) - 'a'] ++;
            if(i - p.length() >= 0) {
                cntS[s.charAt(i - p.length()) - 'a']--;
            }
            if(compare(cntS, cntP)) {
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }

    public boolean compare(int[] c1, int[] c2) {
        for(int i = 0 ;i < 26; i++) {
            if(c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] argv) {
        new Solution2().findAnagrams("cbaebabacd", "abc");
    }
}
