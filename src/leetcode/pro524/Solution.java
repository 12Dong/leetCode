package leetcode.pro524;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        for(String str : dictionary) {
            int i = 0;
            int j = 0;
            while(i < s.length() && j < str.length()) {
                if(s.charAt(i) == str.charAt(j)) {
                    j++;
                }
                i++;
            }
            if(j == str.length()) {
                return str;
            }
        }
        return "";
    }
}
