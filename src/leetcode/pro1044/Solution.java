package leetcode.pro1044;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public String longestDupSubstring(String s) {
        int left = 0;
        int right = s.length() - 1;
        String ans = "";
        while(left <= right) {
            int middle = (left + right) / 2;
            List<String> list = findRepeatedDnaSequences(s, middle);
            if(list.isEmpty()) {
                right = middle - 1;
            } else {
                left = middle + 1;
                if(ans.length() < middle) {
                    ans = list.get(0);
                }
            }
        }
        return ans;
    }


    public List<String> findRepeatedDnaSequences(String s, int l) {
        int P = 131313;
        long[] hash = new long[s.length() + 1];
        long[] p = new long[s.length() + 1];
        Map<Long, Integer> cntMap = new HashMap<>();
        p[0] = 1;
        for(int i = 1; i <= s.length(); i++) {
            hash[i] = hash[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }
        List<String> ans = new LinkedList<>();
        for(int i = 1; i + l - 1 <= s.length(); i++) {
            int j = i + l - 1;
            long h = hash[j] - hash[i - 1] * p[j - i + 1];
            int cnt = cntMap.getOrDefault(h, 0);
            if(cnt == 1) {
                ans.add(s.substring(i - 1, j));
            }
            cntMap.put(h, cnt + 1);
        }
        return ans;
    }

    public static void main(String[] argv) {
        new Solution().longestDupSubstring("banana");
    }
}
